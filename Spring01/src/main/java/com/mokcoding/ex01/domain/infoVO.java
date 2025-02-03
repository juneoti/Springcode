package com.mokcoding.ex01.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok 태그들
@NoArgsConstructor // 기본 생성자
@Getter // getter 메소드
@Setter // setter 메소드
@ToString // toString 메소드
public class infoVO {
	private String name; // parameter name="name"
	private String email; // parameter name="email"
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate; // parameter name="birthDate"
	
}
