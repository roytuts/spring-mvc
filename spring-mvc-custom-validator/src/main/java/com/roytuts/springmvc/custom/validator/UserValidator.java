package com.roytuts.springmvc.custom.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.roytuts.springmvc.custom.validator.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> claszz) {
		return User.class.isAssignableFrom(claszz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.address");
	}

}
