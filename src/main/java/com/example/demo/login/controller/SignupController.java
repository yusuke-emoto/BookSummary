package com.example.demo.login.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.login.domain.model.GroupOrder;
import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class SignupController {
	@Autowired
	private UserService userService;
	//ラジオボタンの実装
	private Map<String,String> radioGender;
	//ラジオボタンの初期化メソッド
	private Map<String,String> initRadioGender(){
		Map<String,String> radio=new LinkedHashMap<>();
		//男性、女性をMapに格納
		radio.put("男性","true");
		radio.put("女性","false");
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
	public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult, Model model) {
		//入力結果を間違えていても,BindingResultクラスで処理してくれる
		//@ValidatedをつけることでSignupFormクラスのバリデーションを行える,(GroupOrder)で実行順序を指定できるようになる
		
		//入力チェックが間違っている場合、ユーザー登録画面に戻る
		if(bindingResult.hasErrors()) {
			//Getリクエスト用のメソッドを呼び出す
			return getSignUp(form,model);
		}
		//formの中身をコンソールに出して確認
		System.out.println(form);
		System.out.println(model);
		
		//insert用変数
		User user=new User(); //ユーザークラスを呼び出す
		user.setUserId(form.getUserId()); //ユーザーID
		user.setPassword(form.getPassword()); //パスワード
		user.setUserName(form.getUserName()); //ユーザー名
		user.setAge(form.getAge()); //年齢
		user.setGender(form.isGender()); //性別
		user.setRole("ROLE_GENERAL"); //ロール（一般）
		//ユーザー登録処理
		boolean result=userService.insert(user); //UserServiceクラスのinsertメソッドを使う
		//ユーザー登録結果の判定
		if(result==true) {
			System.out.println("insert成功");
		}else {
			System.out.println("insert失敗");
		}
		//login.htmlにリダイレクト
		return "redirect:/login";
	}

}
