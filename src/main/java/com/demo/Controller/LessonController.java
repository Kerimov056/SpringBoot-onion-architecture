package com.demo.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.lesson.CreateLessonDto;
import com.demo.dto.lesson.GetLessonDto;
import com.demo.dto.lesson.UpdateLessonDto;
import com.demo.iService.ILessonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/lesson")
public class LessonController {

	@Autowired
	private ILessonService iLessonService;
	
	@PostMapping("/post")
	public ResponseEntity<Void> createLesson(@RequestBody @Valid CreateLessonDto dto) {
		iLessonService.save(dto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/allLesson")
	public ResponseEntity<List<GetLessonDto>> getAllLessons() {
		return ResponseEntity.ok(iLessonService.getAll());
	}

	@GetMapping("/allLesson/{id}")
	public ResponseEntity<GetLessonDto> getLesson(@PathVariable UUID id) {
		return ResponseEntity.ok(iLessonService.findBy(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteLesson(@PathVariable UUID id) {
		iLessonService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateLesson(@PathVariable UUID id, @RequestBody @Valid UpdateLessonDto dto) {
		iLessonService.update(id, dto);
		return ResponseEntity.ok().build();
	}
	
	
	
}
