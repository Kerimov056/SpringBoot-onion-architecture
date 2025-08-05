package com.demo.dto.lesson;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.demo.dto.student.GetStudentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLessonDto {

	private UUID id;

	private String subject;

	private LocalDateTime startLessonTime;

	private Integer grade;

	private UUID teacher_id;
	
	private List<GetStudentDto> getStudentDtos;
}
