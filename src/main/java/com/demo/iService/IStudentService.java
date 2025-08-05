package com.demo.iService;

import java.util.List;
import java.util.UUID;

import com.demo.dto.student.CreateStudentDto;
import com.demo.dto.student.GetStudentDto;
import com.demo.dto.student.UpdateStudentDto;

public interface IStudentService {
	void save(CreateStudentDto dto);
	void delete(UUID id);
	void update(UUID id, UpdateStudentDto dto);
	GetStudentDto findBy(UUID id);
	List<GetStudentDto> getAll();	
	void studetLessonAddAndExit(UUID id,UUID upLessonId);
}
