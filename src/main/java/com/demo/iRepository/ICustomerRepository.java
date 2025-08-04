package com.demo.iRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, UUID> {

}
