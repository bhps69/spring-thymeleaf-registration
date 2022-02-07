package com.example.springbootExample.validation;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.springbootExample.DAO.AppUserDAO;
import com.example.springbootExample.model.UserModel;
import com.example.springbootExample.model.UserModelForm;

@Component
public class UserFormValidator implements Validator{
public EmailValidator emailValidator = EmailValidator.getInstance();
@Autowired
public AppUserDAO appUserDAO;
@Override
public boolean supports(Class<?> clazz) {
	// TODO Auto-generated method stub
	return clazz == UserModelForm.class;
}
@Override
public void validate(Object target, Errors errors) {
	// TODO Auto-generated method stub
	UserModelForm form = (UserModelForm)target;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "valid.userName");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","valid.firstName");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName","valid.lastName");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","valid.email");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","valid.password");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","valid.confirmPassword");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender","valid.gender");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode","valid.countryCode");
	
	if(!emailValidator.isValid(form.getEmail()))
		errors.reject("email", "valid.emailPattern");
	else if(form.getUserId()==null){
		UserModel existUser = appUserDAO.findUserByEmail(form.getEmail());
		if(existUser==null)
		{
			errors.reject("email", "valid.duplicate-email");
		}
	}
	if(!errors.hasFieldErrors("userName")) {
		UserModel user= appUserDAO.findUserByName(form.getUserName());
		if(user.getUserName() ==null)
			errors.reject("userName", "valid.duplicateUserName");
	}
	if(!errors.hasErrors()) {
		if(!form.getPassword().equals(form.getConfirmPassword())) {
			errors.reject("confirmPassword", "valid.MatchConfirmPassword");
		}
	}
}

}
