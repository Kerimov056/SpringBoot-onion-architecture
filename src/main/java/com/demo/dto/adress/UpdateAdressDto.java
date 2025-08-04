package com.demo.dto.adress;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdressDto {

	@NotEmpty(message = "description mutleq olmalidir.!!!")
	@NotNull(message = "description null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 4, max = 1224, message = "min 4 max 1224 olmalidir")
	private String description;
}
