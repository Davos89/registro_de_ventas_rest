package com.davos.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davos.core.dto.SellerDTO;
import com.davos.core.entity.Seller;

@Service
public interface SellerService {
	
	public List<SellerDTO> getAll();
	
	public SellerDTO getByName(String name);

	public SellerDTO getById(int id);

	public boolean createOrUpdate(Seller seller);

	public boolean delete(int id);

}
