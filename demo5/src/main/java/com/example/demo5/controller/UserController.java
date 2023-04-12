package com.example.demo5.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@Validated //get 방식일떄 반드시 선언해주어야  유효성 검사를 시작한다.
public class UserController {
	
	
	//get 방식을때 파라미터 앞에 어떤 유효성 검사를 할지 당연히 지정해 주어야 한다.
	//http://localhost:8080/user?name=홍&age=1
	//get 방식일때 valid 처리
	@GetMapping("/user")
	public User user(@Size(min = 2) @RequestParam String name,
			@NotNull @Min(1) @RequestParam Integer age) {
		User user = new User();
		user.setAge(age);
		user.setName(name);
		return user;
	}
	
	@GetMapping("/user2")
	//object mapper 하고싶다면
	public User user2(@Validated User user) {
		return user;
	}
}
