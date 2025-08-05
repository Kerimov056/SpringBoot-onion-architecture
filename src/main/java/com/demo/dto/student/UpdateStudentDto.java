package com.demo.dto.student;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentDto {
	
	@NotNull(message = "nameAndSurname null ola bilmez ! mutleq olmalidir.!!!")
	private String nameAndSurname;

	@NotNull(message = "userName null ola bilmez ! mutleq olmalidir.!!!")
	private String userName;

	private LocalDateTime birthDate;
	
}
