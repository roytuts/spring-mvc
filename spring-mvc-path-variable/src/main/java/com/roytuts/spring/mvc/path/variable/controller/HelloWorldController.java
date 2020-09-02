package com.roytuts.spring.mvc.path.variable.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloWorldController {

	@GetMapping("/hello/{msg}")
	public String helloWorld(@PathVariable String msg, Model model) {
		model.addAttribute("today", LocalDateTime.now());
		model.addAttribute("msg", msg);

		return "hello";
	}

}
