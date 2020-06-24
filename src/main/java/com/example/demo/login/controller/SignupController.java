package com.example.demo.login.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.login.domain.model.SignupForm;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class SignupController {
	//ラジオボタンの実装
	private Map<String,String> radioGender;
	//ラジオボタンの初期化メソッド
	private Map<String,String> initRadioGender(){
		Map<String,String> radio=new LinkedHashMap<>();
		//男性、女性をMapに格納
		radio.put("男性","Man");
		radio.put("女性","Woman");
		System.out.println(radio);
		return radio;
	}
	//ユーザー登録画面のGET用コントローラー
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {
		//ラジオボタンの初期化メソッドを呼び出す
		radioGender=initRadioGender();
		//ラジオボタン用のMapをModelに登録する
		model.addAttribute("radioGender",radioGender);
		//signup.htmlに画面遷移
		return "login/signup";
	}
	//ユーザー登録用のPOST用コントローラー
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult, Model model) {
		//入力結果を間違えていても,BindingResultクラスで処理してくれる
		//@ValidatedをつけることでSignupFormクラスのバリデーションを行える
		
		//入力チェックが間違っている場合、ユーザー登録画面に戻る
		if(bindingResult.hasErrors()) {
			//Getリクエスト用のメソッドを呼び出す
			return getSignUp(form,model);
		}
		//formの中身をコンソールに出して確認
		System.out.println(form);
		System.out.println(model);
		//login.htmlにリダイレクト
		return "redirect:/login";
	}

}
