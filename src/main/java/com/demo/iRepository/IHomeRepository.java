package com.demo.iRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entities.Home;

@Repository
public interface IHomeRepository extends JpaRepository<Home, UUID> {
	@EntityGraph(attributePaths = { "rooms" })
	@Query("SELECT h FROM Home h WHERE h.id = :id")
	Optional<Home> findByIdWithRooms(UUID id);
}
