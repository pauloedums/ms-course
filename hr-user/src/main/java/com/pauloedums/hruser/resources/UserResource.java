package com.pauloedums.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pauloedums.hruser.entities.User;
import com.pauloedums.hruser.repositories.UserRepository;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserRepository repository;
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
	

	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email){
		User worker = repository.findByEmail(email);
		return ResponseEntity.ok(worker);
	}
}
