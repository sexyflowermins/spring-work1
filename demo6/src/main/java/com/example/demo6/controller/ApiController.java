package com.example.demo6.controller;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.dto.User;

@RestController
@RequestMapping("/api")
@Validated //하나씩 key = value 감사는 명시 해야한다. get 단 dto 방식은 예외
public class ApiController {

	@GetMapping("/test")
	public String test() {
		
		return "TEST";
	}
	
	@GetMapping("/user")
	public User get(@Size(min = 4) @RequestParam String name, @RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age); 
		return user;
	}

	// 구분 ---> http body 데이터 전달 방식
	// 1. json 형식으로 넣어서 서버로 전달 - @RequestBody 선언 해야 함
	// 2. form 태글 활용해서 key=value 구조 (Query String)
	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {
		System.out.println(user);
		return user;
	}
	//두번째 연습
	//x-www-form-urlencoded
	@GetMapping("/user2")
	public User get2(@Validated User reqUser) {
		return reqUser;
	}
}
