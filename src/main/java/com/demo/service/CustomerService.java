package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.adress.GetAdressDto;
import com.demo.dto.customer.CreateCustomerDto;
import com.demo.dto.customer.GetCustomerDto;
import com.demo.dto.customer.UpdateCustomerDto;
import com.demo.entities.Adress;
import com.demo.entities.Customer;
import com.demo.iRepository.IAddressRepository;
import com.demo.iRepository.ICustomerRepository;
import com.demo.iService.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository iCustomerRepository;

	@Autowired
	private IAddressRepository iAddressRepository;

	@Override
	public void save(CreateCustomerDto dto) {
		Adress adress = iAddressRepository.findById(dto.getAdressId())
				.orElseThrow(() -> new RuntimeException("not found"));
		Customer customer = new Customer();
		BeanUtils.copyProperties(dto, customer);
		customer.setAdress(adress);
		iCustomerRepository.save(customer);
	}

	@Override
	public void delete(UUID id) {
	    Customer customer = iCustomerRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Customer not found"));

	    iCustomerRepository.delete(customer);
	}

	@Override
	public void update(UUID id, UpdateCustomerDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public GetCustomerDto findBy(UUID id) {
		Customer customer = iCustomerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("not found"));
		GetCustomerDto getCustomerDto = new GetCustomerDto();
		GetAdressDto getAdressDto = new GetAdressDto();
		BeanUtils.copyProperties(customer, getCustomerDto);
		BeanUtils.copyProperties(customer.getAdress(), getAdressDto);
		getCustomerDto.setGetAdressDto(getAdressDto);
		return getCustomerDto;
	}

	@Override
	public List<GetCustomerDto> getAll() {
		List<Customer> customers = iCustomerRepository.findAll();
		List<GetCustomerDto> getCustomerDtos = new ArrayList<>();
		
		for(Customer cust : customers) {
			getCustomerDtos.add(findBy(cust.getId()));
		}
		return getCustomerDtos;
	}

}
