package com.mokcoding.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mokcoding.ex01.domain.infoVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/example2")
@Log4j // Lombok log4j 기능
public class ExampleController2 {
	
	// 페이지 호출 역할(GET)
	@GetMapping("/send")
	public void sendGET() {
		log.info("sendGET()"); // log 출력 기능
	}

	// 데이터 수신 역할(POST)
	@PostMapping("/send") // RequestMapping POST
	public String sendPOST(@RequestParam("name") String name, @RequestParam("age") int age) {
			// String name = request.getParameter("name");
			// int age = Integer.parseInt(request.getParameter("age"));
		
		log.info("sendPOST()");
		log.info("name = " + name + ", age = " + age);
		return "redirect:/"; // response.sendRedirect();
	}
	
	// info.jsp 페이지 호출
	@GetMapping("/info")
	public void infoGET() {
		log.info("infoGET()");
	}

	// INFO.JSP 페이지에서 전송된 데이터 수신
	@PostMapping("/info")
	public String infoPOST(infoVO vo) {
		// 전송된 데이터는 InfoVO에 바인딩(Binding)
		log.info("infoPOST()");
		log.info("vo = " + vo.toString());
		
		return "redirect:/";
	}

}

