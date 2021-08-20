package com.davos.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.entity.Seller;
import com.davos.core.http_errors.NullEntityException;
import com.davos.core.http_errors.RecordNotFoundException;
import com.davos.core.dto.SellerDTO;
import com.davos.core.repository.SellerRepository;
import com.davos.core.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;


	@Override
	public List<SellerDTO> getAll() {

		List<Seller> sellers = sellerRepository.findAll();
		List<SellerDTO> sellerDTOs = new ArrayList<>();

		for (Seller seller : sellers) {
			sellerDTOs.add(new SellerDTO(seller));
		}

		return sellerDTOs;

	}

	@Override
	public SellerDTO getSeller(String name) {
		return new SellerDTO(sellerRepository.findByName(name));
	}

	@Override
	public SellerDTO getSeller(int id) {
		return new SellerDTO(sellerRepository.findById(id));
	}

	public void createOrUpdate(SellerDTO sellerDTO) {

		Seller seller = sellerDTO.toSeller();
		
		if (seller == null) {
			throw new NullEntityException("Entity of type 'Seller.class' cannot be saved or updated because is null");
		}

		
		sellerRepository.save(seller);

	}

	@Override
	public void delete(int id) {

		Seller seller = sellerRepository.findById(id);

		if (seller == null) {
			throw new RecordNotFoundException("Entity of type 'Seller.class' cannot be deleted because doesn´t exists");
		}

		sellerRepository.delete(seller);

	}
}
