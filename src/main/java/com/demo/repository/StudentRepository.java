package com.demo.repository;

import org.springframework.stereotype.Repository;

import com.demo.entities.Student;
import com.demo.iRepository.IStudentRepository;

@Repository
public class StudentRepository extends GenericRepository<Student, String> implements IStudentRepository {

	protected StudentRepository() {
		super(Student.class);
		// TODO Auto-generated constructor stub
	}

}
