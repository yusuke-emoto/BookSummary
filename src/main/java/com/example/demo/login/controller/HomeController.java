package com.example.demo.login.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	//ホーム画面のGET用メソッド
	@GetMapping("/home")
	public String getHome(Model model) {
		System.out.println(model);
		return "home/homeLayout";
	}

}
