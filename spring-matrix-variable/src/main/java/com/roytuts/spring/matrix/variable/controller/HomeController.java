package com.roytuts.spring.matrix.variable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@GetMapping("/report/{id}")
	public String homePage(@PathVariable String id, @MatrixVariable String q, Model model) {
		System.out.println("id : " + id);
		System.out.println("q: " + q);
		
		model.addAttribute("matrixVarValue", q);
		
		return "index";
	}

}
