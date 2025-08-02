package com.demo.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

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

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Lesson> lessons;
}
