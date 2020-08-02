package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
	//投稿画面のGET用コントローラー
	@GetMapping("/post")
	public String getPost(Model model) {
		return "login/post";
	}
	//投稿画面のPOST用コントローラー
	@PostMapping("/post")
	public String postPost(Model model) {
		return "redirect:/home";
	}
}
