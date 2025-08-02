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

import com.demo.dto.CreateStudentDto;
import com.demo.dto.GetStudentDto;
import com.demo.dto.UpdateStudentDto;
import com.demo.iService.IStudentService;


@RestController
@RequestMapping("/api/student")

public class StudentController {
	
	@Autowired
    private IStudentService studentService;

	@GetMapping("/allStudent")
	public ResponseEntity<List<GetStudentDto>> getAllStudents(){
		List<GetStudentDto> students = studentService.getAll();
        return ResponseEntity.ok(students);
	}
	
	@GetMapping("/allStudent/{id}")
	public ResponseEntity<GetStudentDto> getStudent(@PathVariable UUID id){
		 GetStudentDto student = studentService.findBy(id);
		 return ResponseEntity.ok(student);
	}
	
	@PostMapping("/post")
    public ResponseEntity<Void> createStudent(@RequestBody CreateStudentDto dto) {
        studentService.save(dto);
        return ResponseEntity.ok().build();
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable UUID id, @RequestBody UpdateStudentDto dto) {
        studentService.update(id, dto);
        return ResponseEntity.ok().build();
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
