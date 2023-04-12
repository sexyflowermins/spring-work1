package com.example.demo51.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo51.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user){
		
		if(user.getAge() < 1 || user.getAge() >100 ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);

		}else if (user.getName().equals("")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);

		}else if (user.getEmail().equals("")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);

		}else if (user.getPhoneNumber().equals("")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		System.out.println(user);
		return ResponseEntity.ok(user);
	}
	@PostMapping("/user2")
	public ResponseEntity<User> user2(@Valid @RequestBody User user){
		return ResponseEntity.ok(user);
	}
}
