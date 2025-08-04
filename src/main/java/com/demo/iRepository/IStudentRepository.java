package com.demo.iRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.dto.GetStudentDto;
import com.demo.entities.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, UUID> {
	//burdda istediyin yeni oz methodlarini yaza bilersen.
	//nativeQuery false elemisense query sorgunu burdaki hql tipinde yeni classlarin propertilerin adinda gondersen yox sen nativeQuery = true elemisense SQLdeki addakilarnan sql soprqulari yazmag mecburiyetindesen.
	@Query(value = "from Student", nativeQuery = false)
	List<Student> allStudents();
	
	@Query(value = "from Student s WHERE s.id=:id")
	GetStudentDto findeByStudentId(UUID id);
}
