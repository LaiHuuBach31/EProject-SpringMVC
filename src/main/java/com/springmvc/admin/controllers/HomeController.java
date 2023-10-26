package com.springmvc.admin.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.model.CustomUserDetails;

@Controller
@RequestMapping(value = "/admin")
public class HomeController {
	@RequestMapping("")
	public String adminHome(Model model) {
		model.addAttribute("mess", "Welcome to admin page");
		CustomUserDetails user =  (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		return "admin/home";
	}
}
