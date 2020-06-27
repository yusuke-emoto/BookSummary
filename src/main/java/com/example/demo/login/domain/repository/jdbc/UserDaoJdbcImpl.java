package com.example.demo.login.domain.repository.jdbc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository //データ層のクラス（DAO等のDBサクセスを行うクラス）に付与する
//UserDaoJdbcImplのImplはUserDaoインターフェースを実装しているクラスという意味
public class UserDaoJdbcImpl implements UserDao{ 
	@Autowired //@Componentアノテーションのついたクラスの中から該当するものを探し、newしてインスタンスを突っ込んでくれる
	JdbcTemplate jdbc;
	
	//Userテーブルの件数を取得
	@Override //オーバーライドするよ、@Overrideを付けることでスペルミス等が防げる
	public int count() throws DataAccessException{
		return 0;
	}
	
	//Userテーブルにデータを一件挿入
	@Override
	public int insertOne(User user) throws DataAccessException{
		return 0;
	}
	
	//Userテーブルのデータを一件取得
	@Override
	public User selectOne(String userId) throws DataAccessException{
		return null;
	}
	
	//Userテーブルの全データを取得
	@Override
	public List<User> selectMany() throws DataAccessException{
		return null;
	}
	
	//Userテーブルを一件更新
	@Override
	public int updateOne(User user) throws DataAccessException{
		return 0;
	}
	
	//Userテーブルを一件削除
	@Override
	public int deleteOne(String userId) throws DataAccessException{
		return 0;
	}
	

}
