package com.demo.dto.customer;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerDto {
	@NotEmpty(message = "name mutleq olmalidir.!!!")
	@NotNull(message = "name null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 4, max = 24, message = "min 4 max 24 olmalidir")
	private String name;

	@NotNull(message = "adressId null ola bilmez.!!!")
	private UUID adressId;
}
