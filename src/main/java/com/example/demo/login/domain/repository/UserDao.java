package com.example.demo.login.domain.repository;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.example.demo.login.domain.model.User;

//DaoはData Access Object データ操作のインターフェースを提供する
public interface UserDao {
	//Userテーブルの件数を取得
	public int count() throws DataAccessException;
	
	//Userテーブルにデータを一件挿入（insert)
	public int insertOne(User user) throws DataAccessException;
	
	//Userテーブルのデータを一件取得
	public User selectOne(String userId) throws DataAccessException;
	
	//Userテーブルの全データを取得
	public List<User> selectMany() throws DataAccessException;
	
	//Userテーブルを一件更新
	public int updateOne(User user) throws DataAccessException;
	
	//Userテーブルを一件削除
	public int deleteOne(String userId) throws DataAccessException;

}
