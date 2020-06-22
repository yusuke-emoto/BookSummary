package com.example.demo.login.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	//ログイン画面のGET用コントローラー
	@GetMapping("/login")// /loginを取得したときに↓のメソッドが動く
	public String getLogin() {
		//login.htmlに画面遷移
		return "login/login";
	}
	//ログイン画面のPOST用コントローラー
	@PostMapping("/login")
	public String postLogin() {
		//login.htmlに画面遷移
		return "login/login";
	}

}
