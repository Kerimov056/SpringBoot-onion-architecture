package com.demo.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.home.CreateHomeDto;
import com.demo.dto.home.GetHomeDto;
import com.demo.iService.IHomeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/home")
public class HomeController {

	@Autowired
	private IHomeService iHomeService;

	@PostMapping("/post")
	public ResponseEntity<Void> createHome(@RequestBody @Valid CreateHomeDto dto) {
		iHomeService.save(dto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/allHomes")
	public ResponseEntity<List<GetHomeDto>> getAllHomes() {
		return ResponseEntity.ok(iHomeService.getAll());
	}

	@GetMapping("/allHomes/{id}")
	public ResponseEntity<GetHomeDto> getHomes(@PathVariable UUID id) {
		return ResponseEntity.ok(iHomeService.findBy(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteHome(@PathVariable UUID id) {
		iHomeService.delete(id);
		return ResponseEntity.ok().build();
	}
}
