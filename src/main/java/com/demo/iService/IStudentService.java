package com.demo.iService;

import java.util.List;
import java.util.UUID;

import com.demo.dto.*;

public interface IStudentService {
	void save(CreateStudentDto dto);
	void delete(UUID id);
	void update(UUID id, UpdateStudentDto dto);
	GetStudentDto findBy(UUID id);
	List<GetStudentDto> getAll();
}
