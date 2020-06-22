package com.example.demo.login.domain.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class SignupForm {
	private String userId; //ユーザーID
	private String password; //パスワード
	private String userName; //ユーザー名
	private int age; //年齢
	private String gender; //性別
	
	

}

