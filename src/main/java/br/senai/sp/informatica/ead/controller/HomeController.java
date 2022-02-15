package br.senai.sp.informatica.ead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Index() {
		return "/home/index";
	}
}
