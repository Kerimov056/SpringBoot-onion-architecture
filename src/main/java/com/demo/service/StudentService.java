package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.student.CreateStudentDto;
import com.demo.dto.student.GetStudentDto;
import com.demo.dto.student.UpdateStudentDto;
import com.demo.entities.Lesson;
import com.demo.entities.Student;
import com.demo.iRepository.ILessonRepository;
import com.demo.iRepository.IStudentRepository;
import com.demo.iService.IStudentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService implements IStudentService {

	@Autowired
	private IStudentRepository iStudentRepository;

	@Autowired
	private ILessonRepository iLessonRepository;

	@Override
	public void save(CreateStudentDto dto) {

		Student student = new Student();
		BeanUtils.copyProperties(dto, student);
		List<Lesson> lessons = new ArrayList<>();
		for (UUID id : dto.getLessonIds()) {
			Lesson lesson = iLessonRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + id));
			lesson.setStudentCount(lesson.getStudentCount() + 1);
			iLessonRepository.save(lesson);
			lessons.add(lesson);
		}
		student.setLessons(lessons);
		iStudentRepository.save(student);
	}

	@Override
	public void delete(UUID id) {
		Student student = iStudentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + id));

		for (Lesson lesson : student.getLessons()) {
			lesson.setStudentCount(lesson.getStudentCount() - 1);
			iLessonRepository.save(lesson);
		}
		iStudentRepository.delete(student);
	}

	@Override
	public void update(UUID id, UpdateStudentDto dto) {
		Student student = iStudentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + id));
		BeanUtils.copyProperties(dto, student);

		iStudentRepository.save(student);
	}

	@Override
	public GetStudentDto findBy(UUID id) {
		Student student = iStudentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

		GetStudentDto dto = new GetStudentDto();
		BeanUtils.copyProperties(student, dto);

		List<String> lessonNames = student.getLessons().stream().map(lesson -> lesson.getSubject()).toList();

		dto.setLessonNames(lessonNames);
		return dto;
	}

	@Override
	public List<GetStudentDto> getAll() {
		List<Student> students = iStudentRepository.findAll();

		return students.stream().map(student -> {
			GetStudentDto dto = new GetStudentDto();
			BeanUtils.copyProperties(student, dto);

			List<String> lessonNames = student.getLessons().stream().map(lesson -> lesson.getSubject()).toList();

			dto.setLessonNames(lessonNames);

			return dto;
		}).toList();
	}

	@Override
	public void studetLessonAddAndExit(UUID id, UUID upLessonId) {
		Student student = iStudentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + id));

		boolean isCheck = true;
		for (Lesson lesson : student.getLessons()) {
			if (upLessonId.equals(lesson.getId())) {
				lesson.setStudentCount(lesson.getStudentCount() - 1);
				student.getLessons().remove(lesson);
				isCheck = false;
			}
		}
		if (isCheck == true) {
			Lesson lesson = iLessonRepository.findById(upLessonId)
					.orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + upLessonId));
			lesson.setStudentCount(lesson.getStudentCount() + 1);
			iLessonRepository.save(lesson);
			student.getLessons().add(lesson);
		}

		student.setLessons(student.getLessons());
	}

}
