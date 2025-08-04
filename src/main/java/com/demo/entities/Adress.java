package com.demo.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
	@Id
	@Column(name = "id", unique = true)
    @UuidGenerator
	private UUID id;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "adress")
	private Customer customer;
}
