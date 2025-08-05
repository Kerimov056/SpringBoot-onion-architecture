package com.demo.iService;

import java.util.List;
import java.util.UUID;

import com.demo.dto.lesson.CreateLessonDto;
import com.demo.dto.lesson.GetLessonDto;
import com.demo.dto.lesson.UpdateLessonDto;

public interface ILessonService {
	void save(CreateLessonDto dto);
	void delete(UUID id);
	void update(UUID id, UpdateLessonDto dto);
	GetLessonDto findBy(UUID id);
	List<GetLessonDto> getAll();
}
