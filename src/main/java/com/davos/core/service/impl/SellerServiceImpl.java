package com.davos.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davos.core.entity.Seller;
import com.davos.core.mapper.SellerMapper;
import com.davos.core.dto.SellerDTO;
import com.davos.core.repository.SellerRepository;
import com.davos.core.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private SellerMapper mapper;
	
	public List<SellerDTO> getAll() {
		
		List<Seller> sellers = sellerRepository.findAll();
		List<SellerDTO> sellerDTOs = new ArrayList<>();
		
		for (Seller seller : sellers) {
			sellerDTOs.add(mapper.sellerDTOToSeller(seller));
		}
		
		return sellerDTOs;
		
	}
	
	public SellerDTO getByName(String name) {
		return mapper.sellerDTOToSeller(sellerRepository.findByName(name));
	}
	public SellerDTO getById(int id) {
		return mapper.sellerDTOToSeller(sellerRepository.findById(id));
	}
	
	public boolean createOrUpdate(Seller seller) {
		try {
			sellerRepository.save(seller);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Seller seller = sellerRepository.findById(id);
			sellerRepository.delete(seller);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
