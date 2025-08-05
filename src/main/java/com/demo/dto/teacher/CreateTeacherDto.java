package com.demo.dto.teacher;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeacherDto {

	@NotEmpty(message = "nameAndSurname mutleq olmalidir.!!!")
	@NotNull(message = "nameAndSurname null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 3, max = 30, message = "min 2 max 30 olmalidir")
	private String nameAndSurname;

	@NotEmpty(message = "userName mutleq olmalidir.!!!")
	@NotNull(message = "userName null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 3, max = 30, message = "min 2 max 30 olmalidir")
	private String userName;

	private LocalDateTime birthDate;

}
