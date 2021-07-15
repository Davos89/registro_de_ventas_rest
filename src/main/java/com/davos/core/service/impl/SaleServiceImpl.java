package com.davos.core.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.davos.core.entity.Customer;
import com.davos.core.entity.Grocery;
import com.davos.core.entity.Seller;
import com.davos.core.mapper.SaleMapper;
import com.davos.core.entity.Sale;
import com.davos.core.dto.SaleDTO;
import com.davos.core.repository.CustomerRepository;
import com.davos.core.repository.SaleRepository;
import com.davos.core.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SaleMapper mapper;


	
	public List<SaleDTO> getByCustomerAndYear(int idCustomer, int year) {

		Customer customer = customerRepository.findById(idCustomer);

		List<Sale> salesByCustomerAndYear = new ArrayList<>();

		List<Sale> sales = saleRepository.findByCustomer(customer);

		for (Sale sale : sales) {

			if (sale.getDate().getYear() == year) {
				salesByCustomerAndYear.add(sale);
			}
		}

		return saleToSaleDTOs(salesByCustomerAndYear);
	}

	public List<SaleDTO> getByDate(LocalDate date) {

		List<Sale> sales = saleRepository.findByDate(date);
		return saleToSaleDTOs(sales);

	}

	public float getByYearAndGrocery(int year, int idGrocery) {

		List<SaleDTO> sales = getAll();

		float unidadesTotalesPorAnio = 0;

		for (SaleDTO sale : sales) {
			if (sale.getDate().getYear() == year && sale.getIdGrocery() == idGrocery) {
				unidadesTotalesPorAnio += sale.getUnits();
			}
		}

		return unidadesTotalesPorAnio;

	}

	public List<SaleDTO> getByGrocery(Grocery grocery) {

		List<Sale> sales = saleRepository.findByGrocery(grocery);
		return saleToSaleDTOs(sales);

	}

	public List<SaleDTO> getBySeller(Seller seller) {

		List<Sale> sales = saleRepository.findBySeller(seller);
		return saleToSaleDTOs(sales);

	}

	public List<SaleDTO> getByPagination(Pageable pageable) {
		List<Sale> sales = saleRepository.findAll(pageable).getContent();
		return saleToSaleDTOs(sales);
	}

	public List<SaleDTO> getAll() {
		List<Sale> sales = saleRepository.findAll();
		return saleToSaleDTOs(sales);
	}

	public SaleDTO getById(int id) {

		return mapper.saleToSaleDTO(saleRepository.findById(id));

	}

	public SaleDTO getByDateAndCustomer(LocalDate date, Customer customer) {

		return mapper.saleToSaleDTO(saleRepository.findByDateAndCustomer(date, customer));

	}

	public boolean createOrUpdate(SaleDTO saleDTO) {
		try {
			saleRepository.save(mapper.saleDTOToSale(saleDTO));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			Sale sale = saleRepository.findById(id);
			saleRepository.delete(sale);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private List<SaleDTO> saleToSaleDTOs(List<Sale> sales) {

//		List<SaleDTO> saleDTOs = sales.
		
		List<SaleDTO> saleDTOs = new ArrayList<>();

		for (Sale sale : sales) {
			saleDTOs.add(mapper.saleToSaleDTO(sale));
		}

		return saleDTOs;
	}

}
