package com.demo.iRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;

@Repository
public interface IUserRepository extends CrudRepository<User, UUID> {
	Optional<User> findByEmail(String email);
}
