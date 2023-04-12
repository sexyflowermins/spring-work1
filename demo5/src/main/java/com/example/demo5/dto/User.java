package com.example.demo5.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@NonNull
	private String name;
	//메세지가 내장되어 있어서 지정하지않아도 저장되어있습니다.
	@Min(message = "10보다 커야합니다", value = 10)
	private int age;
	@Email(message = "넌 이메일 형식도 모르니")
	private String email;
	private String phoneNumber;
	
}
