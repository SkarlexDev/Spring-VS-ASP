package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "/home", "/" })
	public String homepage(Model model) {
		model.addAttribute("pageTitle", "Home Page");
		return "Home/index";
	}
}
