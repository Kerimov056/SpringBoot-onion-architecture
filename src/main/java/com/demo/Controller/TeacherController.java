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

import com.demo.dto.teacher.CreateTeacherDto;
import com.demo.dto.teacher.GetTeacherDto;
import com.demo.dto.teacher.UpdateTeacherDto;
import com.demo.iService.ITeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	private ITeacherService iTeacherService;
	
	@PostMapping("/post")
	public ResponseEntity<Void> createTeacher(@RequestBody @Valid CreateTeacherDto dto) {
		iTeacherService.save(dto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/allTeacher")
	public ResponseEntity<List<GetTeacherDto>> getAllTeachers() {
		return ResponseEntity.ok(iTeacherService.getAll());
	}

	@GetMapping("/allTeacher/{id}")
	public ResponseEntity<GetTeacherDto> getTeacher(@PathVariable UUID id) {
		return ResponseEntity.ok(iTeacherService.findBy(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable UUID id) {
		iTeacherService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateTeachere(@PathVariable UUID id, @RequestBody @Valid UpdateTeacherDto dto) {
		iTeacherService.update(id, dto);
		return ResponseEntity.ok().build();
	}
}
