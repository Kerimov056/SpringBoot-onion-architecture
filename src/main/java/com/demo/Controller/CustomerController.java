package com.demo.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.customer.CreateCustomerDto;
import com.demo.dto.customer.GetCustomerDto;
import com.demo.dto.customer.UpdateCustomerDto;
import com.demo.iService.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService iCustomerService;

	@PostMapping("/post")
	public ResponseEntity<Void> createCustomer(@RequestBody @Valid CreateCustomerDto dto) {
		iCustomerService.save(dto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/allCustomers")
	public ResponseEntity<List<GetCustomerDto>> getAllCustomers() {
		return ResponseEntity.ok(iCustomerService.getAll());
	}

	@GetMapping("/allCustomer/{id}")
	public ResponseEntity<GetCustomerDto> getCustomer(@PathVariable UUID id) {
		return ResponseEntity.ok(iCustomerService.findBy(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomers(@PathVariable UUID id) {
		iCustomerService.delete(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateCustomers(@PathVariable UUID id, @RequestBody @Valid UpdateCustomerDto dto) {
		iCustomerService.update(id, dto);
		return ResponseEntity.ok().build();
	}

}
