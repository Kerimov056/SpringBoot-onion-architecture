package com.demo.dto.student;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentDto {

	@NotNull(message = "nameAndSurname null ola bilmez ! mutleq olmalidir.!!!")
	private String nameAndSurname;

	@NotNull(message = "userName null ola bilmez ! mutleq olmalidir.!!!")
	private String userName;

	private LocalDateTime birthDate;

	@NotNull(message = "lessonIds null ola bilmez !")
	private List<UUID> lessonIds;

	// "birthDate": "2025-11-08T15:30:00",
}
