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

import com.demo.dto.adress.CreateAdressDto;
import com.demo.dto.adress.GetAdressDto;
import com.demo.dto.adress.UpdateAdressDto;
import com.demo.iService.IAdressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/adress")
public class AdressController {

	@Autowired
	private IAdressService iAdressService;
	
	@GetMapping("/allAdress")
	public ResponseEntity<List<GetAdressDto>> getAllAdreses() {
		return ResponseEntity.ok(iAdressService.getAll());
	}

	@GetMapping("/allAdress/{id}")
	public ResponseEntity<GetAdressDto> getAdress(@PathVariable UUID id) {
		return ResponseEntity.ok(iAdressService.findBy(id));
	}

	@PostMapping("/post")
	public ResponseEntity<Void> createAdress(@RequestBody @Valid CreateAdressDto dto) {
		iAdressService.save(dto);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateAdress(@PathVariable UUID id, @RequestBody UpdateAdressDto dto) {
		iAdressService.update(id, dto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAdress(@PathVariable UUID id) {
		iAdressService.delete(id);
		return ResponseEntity.ok().build();
	}
}
