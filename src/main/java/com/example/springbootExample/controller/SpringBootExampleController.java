package com.example.springbootExample.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springbootExample.DAO.AppUserDAO;
import com.example.springbootExample.DAO.CountryDAO;
import com.example.springbootExample.model.CountryModel;
import com.example.springbootExample.model.UserModel;
import com.example.springbootExample.model.UserModelForm;
import com.example.springbootExample.validation.UserFormValidator;

@Controller

public class SpringBootExampleController {
	
	@Autowired
	private AppUserDAO appuserDAO;
	@Autowired
	private CountryDAO countryDAO;
	@Autowired
	private UserFormValidator userFormValidator;
	
	protected void InitBinder(WebDataBinder webDataBinder) {
		Object o = webDataBinder.getTarget();
		if(o.getClass()==UserModelForm.class)
		{
			webDataBinder.setValidator(userFormValidator);
		}
	}
	@GetMapping("/")
	public String getPage(Model m) {
		//m.addAttribute("view", view);
		return "welcomePage";
	}
	@GetMapping("/members")
	public String getMembers(Model m) {
		 m.addAttribute("members", appuserDAO.findAllUsers());
		 return "membersPage";
	}
	@GetMapping("RegisterSuccessful")
	public String registerSuccess() {
		return "registerSuccessful";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String newUser(Model m) {
		UserModelForm form = new UserModelForm();
	      List<CountryModel> countries = countryDAO.findAllCountries();

	      m.addAttribute("appUserForm", form);
	      m.addAttribute("countries", countries);

	      return "registerPage";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveRegister(Model model,@ModelAttribute("UserModelForm") @Validated UserModelForm userModelForm,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("countries", Arrays.asList(countryDAO.findAllCountries()));
			return "registerPage";
		}
		
		UserModel newUser = null;
		try {
			newUser = appuserDAO.createUser(userModelForm);
		}
		catch(Exception e) {
			model.addAttribute("countries", Arrays.asList(countryDAO.findAllCountries()));
			model.addAttribute("errrorMessage", "Error"+e.getMessage());
			return "registerPages";
		}
		 redirectAttributes.addFlashAttribute("flashUser", newUser);
	      
	     return "redirect:/RegisterSuccessful";
	}
	
	
}
