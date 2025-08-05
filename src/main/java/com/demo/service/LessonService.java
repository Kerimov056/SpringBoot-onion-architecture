package com.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.lesson.CreateLessonDto;
import com.demo.dto.lesson.GetLessonDto;
import com.demo.dto.lesson.UpdateLessonDto;
import com.demo.dto.student.GetStudentDto;
import com.demo.entities.Lesson;
import com.demo.entities.Teacher;
import com.demo.iRepository.ILessonRepository;
import com.demo.iRepository.ITeacherRepository;
import com.demo.iService.ILessonService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LessonService implements ILessonService {

	@Autowired
	private ILessonRepository iLessonRepository;
	
	@Autowired
	private ITeacherRepository iTeacherRepository;
	
	@Override
	public void save(CreateLessonDto dto) {
		Teacher teacher = iTeacherRepository.findById(dto.getTeacher_id())
				.orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + dto.getTeacher_id()));
		
		Lesson lesson = new Lesson();
		BeanUtils.copyProperties(dto, lesson);
		lesson.setTeacher(teacher);
		iLessonRepository.save(lesson);
	}

	@Override
	public void delete(UUID id) {
		Lesson lesson = iLessonRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + id));
		iLessonRepository.delete(lesson);
	}

	@Override
	public void update(UUID id, UpdateLessonDto dto) {
		Lesson lesson = iLessonRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + id));
		
		Teacher teacher = iTeacherRepository.findById(dto.getTeacher_id())
				.orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + dto.getTeacher_id()));
		BeanUtils.copyProperties(dto, lesson);
		lesson.setTeacher(teacher);
		iLessonRepository.save(lesson);
	}

	@Override
	public GetLessonDto findBy(UUID id) {
		Lesson lesson = iLessonRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + id));
		GetLessonDto getLessonDto = new GetLessonDto();
		BeanUtils.copyProperties(lesson, getLessonDto);
	    getLessonDto.setTeacher_id(lesson.getTeacher().getId());
		List<GetStudentDto> studentDtos =  lesson.getStudents().stream().map(student ->{
			return new GetStudentDto(
	                student.getId(),
	                student.getNameAndSurname(),
	                student.getUserName(),
	                student.getBirthDate(),
	                List.of(lesson.getSubject())
	            );
	        }).toList();
		getLessonDto.setGetStudentDtos(studentDtos);
		return getLessonDto;
	}

	@Override
	public List<GetLessonDto> getAll() {
	    List<Lesson> lessons = iLessonRepository.findAll();

	    return lessons.stream().map(lesson -> {
	        List<GetStudentDto> studentDtos = lesson.getStudents().stream().map(student -> {
	            return new GetStudentDto(
	                student.getId(),
	                student.getNameAndSurname(),
	                student.getUserName(),
	                student.getBirthDate(),
	                List.of(lesson.getSubject())
	            );
	        }).toList();

	        return new GetLessonDto(
	            lesson.getId(),
	            lesson.getSubject(),
	            lesson.getStartLessonTime(),
	            lesson.getGrade(),
	            lesson.getTeacher().getId(),
	            studentDtos
	        );
	    }).toList();
	}


}
