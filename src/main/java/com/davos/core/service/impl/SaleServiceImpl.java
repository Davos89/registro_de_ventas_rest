package com.davos.core.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.davos.core.entity.Customer;
import com.davos.core.entity.Grocery;
import com.davos.core.entity.Seller;
import com.davos.core.http_errors.NullEntityException;
import com.davos.core.http_errors.RecordNotFoundException;
import com.davos.core.entity.Sale;
import com.davos.core.dto.SaleByDateDTO;
import com.davos.core.dto.SaleByMonthDTO;
import com.davos.core.dto.SaleDTO;
import com.davos.core.repository.CustomerRepository;
import com.davos.core.repository.GroceryRepository;
import com.davos.core.repository.SaleRepository;
import com.davos.core.repository.SellerRepository;
import com.davos.core.service.SaleService;

import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class SaleServiceImpl implements SaleService {

	private final String[] MONTHS = new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
	
	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private GroceryRepository groceryRepository;

	@Override
	public List<SaleDTO> getSales(int idCustomer, int year) {

		Customer customer = customerRepository.findById(idCustomer);

		List<Sale> salesByCustomerAndYear = new ArrayList<>();

		// Select all sales by customer
		List<Sale> sales = saleRepository.findByCustomer(customer);

		// Filter again, this time also per year
		for (Sale sale : sales) {

			if (sale.getDate().getYear() == year) {
				salesByCustomerAndYear.add(sale);
			}
		}

		return saleToSaleDTOs(salesByCustomerAndYear);
	}

	@Override
	public float getUnits(int idSeller, int year, int idGrocery) {

		Seller seller = sellerRepository.findById(idSeller);

		Grocery grocery = groceryRepository.findById(idGrocery);

		List<Sale> sales = saleRepository.findBySellerAndGrocery(seller, grocery);

		float totalUnitsPerYear = 0;

		// We'll count all units sold in this 'year'
		for (Sale sale : sales) {
			if (sale.getDate().getYear() == year) {
				totalUnitsPerYear += sale.getUnits();
			}
		}

		return totalUnitsPerYear;
	}

	@Override
	public List<SaleDTO> getSales(LocalDate date) {

		List<Sale> sales = saleRepository.findByDate(date);
		return saleToSaleDTOs(sales);

	}

	@Override
	public float getUnits(LocalDate localDate) {
		List<SaleDTO> sales = getSales(localDate);

		float units = 0;

		for (SaleDTO sale : sales) {
			units += sale.getUnits();
		}

		return units;
	}

	@Override
	public List<SaleDTO> getSales(int idGocery, LocalDate dateInit, LocalDate dateEnd) {

		List<Sale> sales = saleRepository.findByGrocery(groceryRepository.findById(idGocery));
		List<Sale> salesBetweenDates = new ArrayList<>();

		for (Sale sale : sales) {
			LocalDate date = sale.getDate();

			// This variable determines if the current sale date is between the two dates
			// passed by parameter
			boolean isBetweenBothDates = (date.equals(dateInit) || date.isAfter(dateInit))
					&& (date.equals(dateEnd) || date.isBefore(dateEnd));

			// If so, the sale is added to the list
			if (isBetweenBothDates) {
				salesBetweenDates.add(sale);
			}
		}

		return saleToSaleDTOs(salesBetweenDates);

	}

	@Override
	public List<SaleByDateDTO> getSalesByDates(int idGrocery, Set<LocalDate> dates) {

		List<SaleByDateDTO> salesByDate = new ArrayList<>();

		// Filter the sales by an ordered Set of dates and creates 
		// one SaleByDateDTO for each date
		for (LocalDate date : dates) {

			List<SaleDTO> sales = getSales(date);

			salesByDate.add(new SaleByDateDTO(date, sales));
		}

		return salesByDate;
	}
	
	@Override
	public List<SaleByMonthDTO> getSalesByMonth(int year,int idGrocery){
		
		List<SaleByMonthDTO> salesByMonth = new ArrayList<>();
		
		
		
		for (int i = 0; i < 12; i++) {
			salesByMonth.add(new SaleByMonthDTO(MONTHS[i], 0, 0));
		}
		
		List<Sale> sales = saleRepository.findByGrocery(groceryRepository.findById(idGrocery));
		
		for (Sale sale : sales) {
			
			LocalDate date = sale.getDate(); 
			
			if (date.getYear() == year) {
				SaleByMonthDTO s = salesByMonth.get(date.getMonthValue() -1);
				
				s.setAmount(s.getAmount() + (int)(sale.getUnits() * sale.getUnitPrice()));
				
				s.setUnits(s.getUnits() + (int)sale.getUnits());
			}
		}
		
		return salesByMonth;
		
	}

	@Override
	public Set<LocalDate> getDates(int idGrocery, int year) {

		List<Sale> sales = saleRepository.findAll();

		Set<LocalDate> dates = new TreeSet<>();

		for (Sale sale : sales) {

			if (sale.getGrocery().getId() == idGrocery && sale.getDate().getYear() == year) {
				dates.add(sale.getDate());
			}
		}

		return dates;

	}

	@Override
	public float getUnits(int year, int idGrocery) {

		List<Sale> sales = saleRepository.findByGrocery(groceryRepository.findById(idGrocery));

		float unitsByYear = 0;

		for (Sale sale : sales) {
			if (sale.getDate().getYear() == year) {
				unitsByYear += sale.getUnits();
			}
		}

		return unitsByYear;

	}

	@Override
	public int getAmount(int year, int idGrocery) {
		List<Sale> sales = saleRepository.findByGrocery(groceryRepository.findById(idGrocery));

		int amountByYear = 0;

		for (Sale sale : sales) {
			if (sale.getDate().getYear() == year) {
				amountByYear += sale.getUnits() * sale.getUnitPrice();
			}
		}

		return amountByYear;
	}

	@Override
	public List<SaleDTO> getSales(Grocery grocery) {

		List<Sale> sales = saleRepository.findByGrocery(grocery);
		return saleToSaleDTOs(sales);

	}

	@Override
	public List<SaleDTO> getSales(Seller seller) {

		List<Sale> sales = saleRepository.findBySeller(seller);
		return saleToSaleDTOs(sales);

	}

	@Override
	public List<SaleDTO> getSales(Pageable pageable) {
		List<Sale> sales = saleRepository.findAll(pageable).getContent();
		return saleToSaleDTOs(sales);
	}

	@Override
	public SaleDTO getSale(int id) {

		Sale sale = saleRepository.findById(id);

		if (sale == null) {
			throw new RecordNotFoundException("Record '" + id + "' not found.");
		}

		return new SaleDTO(sale);

	}

	@Override
	public SaleDTO getSale(LocalDate date, Customer customer) {

		Sale sale = saleRepository.findByDateAndCustomer(date, customer);

		if (sale == null) {
			throw new RecordNotFoundException(
					"Record not found in date '" + date + "' and customer '" + customer.getId() + "'.");
		}
		return new SaleDTO(sale);

	}

	@Override
	public void createOrUpdate(SaleDTO saleDTO) {

		Sale sale = saleDTO.toSale();

		if (sale == null) {
			throw new NullEntityException(
					"Entity of type '" + Sale.class + "' cannot be saved or updated because is null");
		}

		saleRepository.save(sale);

	}

	@Override
	public void delete(int id) {

		Sale sale = saleRepository.findById(id);

		if (sale == null) {
			throw new RecordNotFoundException("Entity of type '" + Sale.class + "' cannot be deleted because is null");
		}

		saleRepository.delete(sale);

	}

	private List<SaleDTO> saleToSaleDTOs(List<Sale> sales) {

//		List<SaleDTO> saleDTOs = sales.
		
		Function<Sale, SaleDTO> toDto = (sale) -> new SaleDTO(sale);
		
		List<SaleDTO> saleDTOs = sales.stream()
				.map(toDto).collect(Collectors.toList());

//		for (Sale sale : sales) {
//			saleDTOs.add(new SaleDTO(sale));
//		}

		return saleDTOs;
	}

}
