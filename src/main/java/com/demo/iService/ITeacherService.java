package com.demo.iService;

import java.util.List;
import java.util.UUID;

import com.demo.dto.teacher.CreateTeacherDto;
import com.demo.dto.teacher.GetTeacherDto;
import com.demo.dto.teacher.UpdateTeacherDto;

public interface ITeacherService {
	void save(CreateTeacherDto dto);
	void delete(UUID id);
	void update(UUID id, UpdateTeacherDto dto);
	GetTeacherDto findBy(UUID id);
	List<GetTeacherDto> getAll();
}
