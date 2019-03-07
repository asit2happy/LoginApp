package com.sathya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.model.Login;
import com.sathya.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private  LoginService  service;

	@RequestMapping(value="/getLoginPage")
	public  String  showLoginPage(ModelMap  mm) {
		Login  loginObj=new  Login();
		mm.addAttribute("loginCmd", loginObj);
		return  "login";
	}
	
	@RequestMapping(value="/checkLogin", method=RequestMethod.POST)
	public  ModelAndView   checkLogin(@Valid @ModelAttribute("loginCmd") Login  login, BindingResult result) {
		if(result.hasErrors()) {
			return  new  ModelAndView("login");
		}
		else {
			String username=login.getUsername();
			String  password=login.getPassword();
			boolean  flag=service.isUserValid(username, password);
			if(flag==true) {
				return  new  ModelAndView("success","msg","Login Sucess");
			}
			else {
				return  new  ModelAndView("failure", "msg", "Login Failed");
			}
		}
	}

}




