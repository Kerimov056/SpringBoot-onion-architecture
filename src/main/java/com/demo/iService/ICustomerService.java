package com.demo.iService;

import java.util.List;
import java.util.UUID;

import com.demo.dto.customer.CreateCustomerDto;
import com.demo.dto.customer.GetCustomerDto;
import com.demo.dto.customer.UpdateCustomerDto;

public interface ICustomerService {
	void save(CreateCustomerDto dto);
	void delete(UUID id);
	void update(UUID id, UpdateCustomerDto dto);
	GetCustomerDto findBy(UUID id);
	List<GetCustomerDto> getAll();
}
