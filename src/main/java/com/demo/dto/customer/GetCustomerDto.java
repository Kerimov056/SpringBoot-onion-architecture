package com.demo.dto.customer;

import java.util.UUID;

import com.demo.dto.adress.GetAdressDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerDto {
	private UUID id;
	private String name;
	private GetAdressDto getAdressDto;
}
