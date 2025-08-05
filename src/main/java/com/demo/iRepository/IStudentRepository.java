package com.demo.iRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, UUID> {

}
