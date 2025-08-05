package com.demo.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToMany(mappedBy = "lessons")
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @Column(name = "subject", nullable = false)
    private String subject;
    
    @Column(name = "studentCount")
    private Integer studentCount = 0; 
    
    @Column(name = "startLessonTime")
    private LocalDateTime startLessonTime;

    @Column(name = "grade")
    private Integer grade;
}
