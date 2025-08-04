package com.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateStudentDto {

	@NotEmpty(message = "username mutleq olmalidir.!!!")
	@NotNull(message = "username null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 4, max = 24, message = "min4 max 24 olmalidir")
	private String nameAndSurname;
	
	@NotEmpty(message = "username mutleq olmalidir.!!!")
	@NotNull(message = "username null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 4, max = 24, message = "min4 max 24 olmalidir")
	private String userName;
	
	//@Email
}
