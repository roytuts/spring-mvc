package com.roytuts.spring.matrix.variable.in.url.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@GetMapping("owner/{ownerId}/report/{reportId}")
	public String homePage(@PathVariable String ownerId, @MatrixVariable(value = "q", pathVar = "ownerId") String q1,
			@PathVariable String reportId, @MatrixVariable(value = "q", pathVar = "reportId") String q2, Model model) {
		System.out.println("ownerId : " + ownerId);
		System.out.println("reportId : " + reportId);

		System.out.println("q1 : " + q1);
		System.out.println("q2 : " + q2);

		model.addAttribute("q1", q1);
		model.addAttribute("q2", q2);

		return "index";
	}

}
