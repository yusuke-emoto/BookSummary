package com.example.demo.login.domain.model;
import java.util.Date;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank //必須入力
	@Email //メールアドレス形式
	private String userId; //ユーザーID
	
	@NotBlank //必須入力
	@Length(min=4,max=100) //長さ４から100桁
	@Pattern(regexp="^[a-zA-Z0-9]+$") //半角英数字のみ
	private String password; //パスワード
	
	@NotBlank //必須入力
	private String userName; //ユーザー名
	
	@Min(0) //値が０から
	@Max(100) //100まで
	private int age; //年齢
	
	@NotBlank
	private String gender; //性別
	
	

}

