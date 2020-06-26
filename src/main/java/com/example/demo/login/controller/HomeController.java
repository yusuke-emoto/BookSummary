package com.example.demo.login.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	//ホーム画面のGET用メソッド
	@GetMapping("/home")
	public String getHome(Model model) {
		//コンテンツ部分にホーム画面を表示するために文字列をModelに登録
		model.addAttribute("contents","home/home :: home_contents");
		System.out.println(model);
		return "home/homeLayout";
	}
	//ログアウト用メソッド
	@PostMapping("/logout")
	public String postLogout() {
		//ログイン画面へリダイレクト
		return "redirect:/login";
		
	}

}
