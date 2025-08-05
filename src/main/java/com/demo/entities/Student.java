package com.demo.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id", unique = true)
    @UuidGenerator
    private UUID id;

    @Column(name = "name_surname", nullable = false, length = 24)
    private String nameAndSurname;

    @Column(name = "username", nullable = false, length = 24, unique = true)
    private String userName;

    @Column(name = "birth_date",nullable = true)
    private LocalDateTime birthDate;

    @ManyToMany
    @JoinTable(
        name = "student_lessons",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private List<Lesson> lessons;
}
