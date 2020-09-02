package com.roytuts.spring.mvc.path.variable.regex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloWorldController {

	@GetMapping("hello/{fileName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
	public String helloWorld(@PathVariable String fileName, @PathVariable String version,
			@PathVariable String extension, Model model) {
		model.addAttribute("fileName", fileName + version + extension);
		
		return "hello";
	}

}
