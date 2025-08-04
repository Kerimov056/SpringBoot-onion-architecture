package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.adress.CreateAdressDto;
import com.demo.dto.adress.GetAdressDto;
import com.demo.dto.adress.UpdateAdressDto;
import com.demo.entities.Adress;
import com.demo.iRepository.IAddressRepository;
import com.demo.iService.IAdressService;

@Service
public class AdressService implements IAdressService {

	@Autowired
	private IAddressRepository iAddressRepository;
	
	@Override
	public void save(CreateAdressDto dto) {
		Adress newAdress = new Adress();
		BeanUtils.copyProperties(dto, newAdress);
		iAddressRepository.save(newAdress);
	}

	@Override
	public void delete(UUID id) {
		Optional<Adress> adress = iAddressRepository.findById(id);
		if(!adress.isPresent()) throw new RuntimeException("not found");
		iAddressRepository.delete(adress.get());
	}

	@Override
	public void update(UUID id, UpdateAdressDto dto) {
		Optional<Adress> adress = iAddressRepository.findById(id);
		if(!adress.isPresent()) throw new RuntimeException("not found");
		BeanUtils.copyProperties(dto, adress.get());
		iAddressRepository.save(adress.get());
	}

	@Override
	public GetAdressDto findBy(UUID id) {
		Optional<Adress> adress = iAddressRepository.findById(id);
		if(!adress.isPresent()) throw new RuntimeException("not found");
		GetAdressDto dto =  new GetAdressDto();
		BeanUtils.copyProperties(adress.get(), dto);
		return dto;
	}

	@Override
	public List<GetAdressDto> getAll() {
		List<Adress> adresses = iAddressRepository.findAll();
		List<GetAdressDto> getAdressDtos = new ArrayList<>();
		for(Adress adress : adresses) {
			GetAdressDto getAdressDto = new GetAdressDto();
			BeanUtils.copyProperties(adress, getAdressDto);
			getAdressDtos.add(getAdressDto);
		}
		return getAdressDtos;
	}

}
