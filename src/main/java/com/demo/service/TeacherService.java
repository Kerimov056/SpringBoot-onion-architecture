package com.demo.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.teacher.CreateTeacherDto;
import com.demo.dto.teacher.GetTeacherDto;
import com.demo.dto.teacher.UpdateTeacherDto;
import com.demo.entities.Teacher;
import com.demo.iRepository.ITeacherRepository;
import com.demo.iService.ITeacherService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherService implements ITeacherService {

	@Autowired
	private ITeacherRepository iTeacherRepository;

	@Override
	public void save(CreateTeacherDto dto) {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(dto, teacher);
		iTeacherRepository.save(teacher);
	}

	@Override
	public void delete(UUID id) {
		Teacher teacher = iTeacherRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + id));
		iTeacherRepository.delete(teacher);
	}

	@Override
	public void update(UUID id, UpdateTeacherDto dto) {
		Teacher teacher = iTeacherRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + id));

		BeanUtils.copyProperties(dto, teacher);
		iTeacherRepository.save(teacher);
	}

	@Override
	public GetTeacherDto findBy(UUID id) {
		Teacher teacher = iTeacherRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + id));

		return mapToGetTeacherDto(teacher);
	}

	@Override
	public List<GetTeacherDto> getAll() {
		return iTeacherRepository.findAll().stream().map(this::mapToGetTeacherDto).collect(Collectors.toList());
	}

	private GetTeacherDto mapToGetTeacherDto(Teacher teacher) {
		List<String> subjectLessonNames = teacher.getLessons() != null
				? teacher.getLessons().stream().map(lesson -> lesson.getSubject()).collect(Collectors.toList())
				: List.of();

		return new GetTeacherDto(teacher.getId(), teacher.getNameAndSurname(), teacher.getUserName(),
				teacher.getBirthDate(), subjectLessonNames);
	}

}
