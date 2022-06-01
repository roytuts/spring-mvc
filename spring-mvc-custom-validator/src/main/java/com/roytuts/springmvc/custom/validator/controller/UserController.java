package com.roytuts.springmvc.custom.validator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roytuts.springmvc.custom.validator.UserValidator;
import com.roytuts.springmvc.custom.validator.model.User;

@Controller
@RequestMapping("/register")
public class UserController {

	@Autowired
	private UserValidator userValidator;

	@GetMapping
	public String setupUserForm(Model model) {
		User user = new User();
		
		model.addAttribute("userForm", user);
		
		return "add";
	}

	@PostMapping
	public String submitUserForm(@ModelAttribute("userForm") User user, BindingResult result, Model model) {
		userValidator.validate(user, result);

		if (result.hasErrors()) {
			return "add";
		}

		// save the object user to some persistent storage
		// return to the success page
		model.addAttribute("success", "User successfully saved");

		return "success";
	}

}
