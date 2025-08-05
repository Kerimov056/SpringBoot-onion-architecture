package com.demo.dto.student;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentDto {
	private UUID id;
	private String nameAndSurname;
	private String userName;
	private LocalDateTime birthDate;
	private List<String> lessonNames;
}
