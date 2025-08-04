package com.demo.iService;

import java.util.List;
import java.util.UUID;

import com.demo.dto.adress.CreateAdressDto;
import com.demo.dto.adress.GetAdressDto;
import com.demo.dto.adress.UpdateAdressDto;

public interface IAdressService {
	void save(CreateAdressDto dto);
	void delete(UUID id);
	void update(UUID id, UpdateAdressDto dto);
	GetAdressDto findBy(UUID id);
	List<GetAdressDto> getAll();
}
