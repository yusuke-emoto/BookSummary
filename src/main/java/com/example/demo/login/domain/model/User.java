package com.example.demo.login.domain.model;
import java.util.Date;
import lombok.Data;

//ユーザーテーブルのカラムをフィールドで持つためのクラス
@Data //getterやsetterを自動で作る
public class User {
	private String userId; //ユーザーID
	private String password; //パスワード
	private String userName; //ユーザー名
	private int age; //年齢
	private boolean gender; //性別
	private String role; //ロール

}
