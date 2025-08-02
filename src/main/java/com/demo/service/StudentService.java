package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.CreateStudentDto;
import com.demo.dto.GetStudentDto;
import com.demo.dto.UpdateStudentDto;
import com.demo.entities.Student;
import com.demo.iRepository.IStudentRepository;
import com.demo.iService.IStudentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public void save(CreateStudentDto dto) {
		Student student = new Student();
		student.setId(UUID.randomUUID());
		student.setUserName(dto.getUserName());
		student.setNameAndSurname(dto.getNameAndSurname());
		studentRepository.save(student);
	}

	@Override
	public void delete(UUID id) {
		Student student = studentRepository.findById(id.toString());
		if(student == null) throw new RuntimeException("student not found");
		studentRepository.delete(student);
	}

	@Override
	public void update(UUID id, UpdateStudentDto dto) {
		Student student = studentRepository.findById(id.toString());
		if(student == null) throw new RuntimeException("student not found");
		student.setNameAndSurname(dto.getNameAndSurname());
		student.setUserName(dto.getUserName());
		studentRepository.update(student);
	}

	@Override
	public GetStudentDto findBy(UUID id) {
		 Student student = studentRepository.findById(id.toString());
		 if(student == null) throw new RuntimeException("student not found");
	        return toGetDto(student);
	}

	@Override
	public List<GetStudentDto> getAll() {
		List<Student> students = studentRepository.findAll();
		List<GetStudentDto> getStudentDtos = new ArrayList<>();
		for(Student stdStudent : students) {
			GetStudentDto getStudentDto = new GetStudentDto();
			getStudentDto.setId(stdStudent.getId());
			getStudentDto.setNameAndSurname(stdStudent.getNameAndSurname());
			getStudentDto.setUserName(stdStudent.getUserName());
			getStudentDtos.add(getStudentDto);
		}
		return getStudentDtos;
	}
	
    private GetStudentDto toGetDto(Student student) {
        GetStudentDto dto = new GetStudentDto();
        dto.setId(student.getId());
        dto.setNameAndSurname(student.getNameAndSurname());
        dto.setUserName(student.getUserName());
        return dto;
    }

}
