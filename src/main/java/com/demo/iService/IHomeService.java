package com.demo.iService;

import java.util.List;
import java.util.UUID;

import com.demo.dto.home.CreateHomeDto;
import com.demo.dto.home.GetHomeDto;
import com.demo.dto.home.UpdateHomeDto;

public interface IHomeService {
	void save(CreateHomeDto dto);
	void delete(UUID id);
	void update(UUID id, UpdateHomeDto dto);
	GetHomeDto findBy(UUID id);
	List<GetHomeDto> getAll();
}
