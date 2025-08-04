package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.CreateStudentDto;
import com.demo.dto.GetStudentDto;
import com.demo.dto.UpdateStudentDto;
import com.demo.entities.Student;
import com.demo.iRepository.IStudentRepository;
import com.demo.iService.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentRepository iStudentRepository;

	@Override
	public void save(CreateStudentDto dto) {
		Student newStudent = new Student();
		BeanUtils.copyProperties(dto, newStudent);
		iStudentRepository.save(newStudent);
	}

	@Override
	public void delete(UUID id) {
		Student stdStudent = iStudentRepository.getById(id);
		if (stdStudent == null)
			throw new RuntimeException("not found");
		iStudentRepository.delete(stdStudent);
	}

	@Override
	public void update(UUID id, UpdateStudentDto dto) {
		Student stdStudent = iStudentRepository.getById(id);
		if (stdStudent == null)
			throw new RuntimeException("not found");
		BeanUtils.copyProperties(dto, stdStudent);
		iStudentRepository.save(stdStudent);
	}

	@Override
	public GetStudentDto findBy(UUID id) {
		Student stdStudent = iStudentRepository.getById(id);
		GetStudentDto getStudentDto = new GetStudentDto();
		BeanUtils.copyProperties(stdStudent, getStudentDto);
		return getStudentDto;
	}

	@Override
	public List<GetStudentDto> getAll() {
		List<Student> getStudent = iStudentRepository.findAll();
		List<GetStudentDto> getStudentDtos = new ArrayList<>();
		for (Student std : getStudent) {
			GetStudentDto dto = new GetStudentDto();
			BeanUtils.copyProperties(std, dto);
			getStudentDtos.add(dto);
		}
		return getStudentDtos;
	}

}
