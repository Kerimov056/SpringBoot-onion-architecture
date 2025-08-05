package com.demo.iRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, UUID> {

}
