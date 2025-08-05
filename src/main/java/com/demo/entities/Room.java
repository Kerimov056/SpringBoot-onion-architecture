package com.demo.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
	
	@Id
	@Column(name = "id", unique = true)
    @UuidGenerator
	private UUID id;

	@Column(name = "whichRoom")
	private String whichRoom;
	
	@Column(name = "roomAreaKV")
	private String roomAreaKV;
	
	@ManyToOne
	@JoinColumn(name = "home_id")  // foreign key
	@JsonBackReference
	private Home home;

}
