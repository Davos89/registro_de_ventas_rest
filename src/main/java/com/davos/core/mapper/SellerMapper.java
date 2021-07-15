package com.davos.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.davos.core.dto.SellerDTO;
import com.davos.core.entity.Seller;

@Mapper(componentModel = "spring")
public interface SellerMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	SellerDTO sellerToSellerDTO(Seller seller);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	Seller sellerDTOToSeller(SellerDTO sellerDTO);
}
