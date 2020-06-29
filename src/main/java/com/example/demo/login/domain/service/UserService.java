package com.example.demo.login.domain.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.login.domain.repository.UserDao;
import com.example.demo.login.domain.model.User;

@Service //サービス層のクラスに付与する。業務処理を提供する
public class UserService {
	@Autowired
	UserDao dao;
	
	//inset用メソッド
	public boolean insert(User user) {
		//insert実行
		int rowNumber=dao.insertOne(user);
		//判定用変数
		boolean result=false;
		if(rowNumber>0) {
			//insert成功
			result=true;
		}
		return result;
	}

}
