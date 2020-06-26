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
	//ValidGroup.class(1,2,3)はバリデーション（入力チェック）の順序の指定
	@NotBlank(groups = ValidGroup1.class) //必須入力、一番目にチェックされる項目
	@Email(groups = ValidGroup2.class) //メールアドレス形式、二番目にチェックされる
	private String userId; //ユーザーID
	
	@NotBlank(groups = ValidGroup1.class) //必須入力
	@Length(min=4,max=100,groups = ValidGroup2.class) //長さ４から100桁
	@Pattern(regexp="^[a-zA-Z0-9]+$",groups = ValidGroup3.class) //半角英数字のみ
	private String password; //パスワード
	
	@NotBlank(groups = ValidGroup1.class) //必須入力
	private String userName; //ユーザー名
	
	@Min(value=1,groups = ValidGroup2.class) //値が０から
	@Max(value=100,groups = ValidGroup2.class) //100まで
	private int age; //年齢
	
	private boolean gender; //性別
	
	

}

