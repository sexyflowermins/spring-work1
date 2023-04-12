package com.example.demo7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //IoC 처리됨
public class UserController {
	
	//http://localhost:8080/
	//http://localhost:8080/user
	@GetMapping({"/","user"})
	public String userPage(Model model) {

		//yml 파일 설정
//		prefix: /WEB-INF/view/
//	    suffix: .jsp
		
		
		//데이터를 내려보내고 싶다면
		model.addAttribute("principal","헬로우~~~");
		return "user";
	}
	
}
