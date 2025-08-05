package com.demo.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Home {
	
	@Id
	@Column(name = "id", unique = true)
    @UuidGenerator
	private UUID id;

	@Column(name = "ipAddress")
	private String ipAddress;
	
	@Column(name = "homeAreaKV")
	private String homeAreaKV;
	
	@OneToMany(mappedBy = "home", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Room> rooms;
}
