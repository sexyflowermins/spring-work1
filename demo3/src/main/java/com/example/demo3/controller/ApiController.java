package com.example.demo3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	//80 포트 번호는 주소창에서 생략 가능 합니다.
	//http://localhost:80/api/hello
	//http://localhost/api/hello
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	//MINE TYPE 타입 : text/plain 으로 응답 처리 해주세요
	//http://localhost/api/text
	//응답 처리 결과 응답 : text/plain
	@GetMapping("/text")
	public String text() {
		return "응답 : "+"text/plain";
	}
	
	//response json 형식으로 내려주기
	// ->/api/json
	@PostMapping("/json")
	public User json(@RequestBody User user) {
		System.out.println(user.toString());
		return user;
	}
	
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		System.out.println(user.toString());
		//http 메세지 코드를 200으로 직접 세팅
		//http 메세지 body 데이터를 --> user object
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	/**
	 * 백엔드 개발자 위치
	 * 클라이언트 (모바일) --> 요청(http 통신)
	 * 데이터로 반환 처리(json 형식)
	 * 매번 새로운 요청 마다 다른 형식으로 리턴 해주면 api 계속 개발
	 * 일곽적인 형식을 만들어서 던져주면 api 개발이 편함
	 */
	@PutMapping("/put2")
	public ResponseEntity<String> put2(@RequestBody User user){
		
		//정상적인 값이 들어 왔는지 확인 또는 요청한 사용자가 인증된 사용자 인지 확인
		
		//
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		//201 생성,수정
		return new ResponseEntity<>(user.toString(),headers,HttpStatus.CREATED);
	}
	//문제 
	//ResponseEntity 활용해서 응답을 내려보자
	@PutMapping("/put3")
	public ResponseEntity<String> put3(@RequestBody User user){
		System.out.println(user.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);

		return new ResponseEntity<>(user.toString(),HttpStatus.CREATED);
	}
}
