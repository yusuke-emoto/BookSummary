package com.example.demo.login.domain.repository.jdbc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository //データ層のクラス（DAO等のDBサクセスを行うクラス）に付与する,//UserDaoJdbcImplのImplはUserDaoインターフェースを実装しているクラスという意味
public class UserDaoJdbcImpl implements UserDao{ 
	@Autowired //@Componentアノテーションのついたクラスの中から該当するものを探し、newしてインスタンスを突っ込んでくれる
	JdbcTemplate jdbc; //jdbcテンプレートを使用
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//Userテーブルの件数を取得
	@Override //オーバーライドするよ、@Overrideを付けることでスペルミス等が防げる
	public int count() throws DataAccessException{
		//全権取得してカウント
		int count=jdbc.queryForObject("SELECT COUNT(*) FROM m_user", Integer.class);
		return count;
	}
	
	//Userテーブルにデータを一件取得
	@Override
	public int insertOne(User user) throws DataAccessException{
		//パスワードを暗号化
		String password=passwordEncoder.encode(user.getPassword());
		//ユーザーテーブルに一件登録するSQL
		String sql ="INSERT INTO m_user("
				+ " user_id,"
				+ " password,"
				+ " user_name,"
				+ " age,"
				+ " gender,"
				+ " role)"
				+ " VALUES(?,?,?,?,?,?)";
		
		//一件挿入
		int rowNumber=jdbc.update(sql
				, user.getUserId()
				, password
				, user.getUserName()
				, user.getAge()
				, user.isGender()
				, user.getRole());
		
		return rowNumber;
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
		//パスワードを暗号化
		String password=passwordEncoder.encode(user.getPassword());
		//一件更新するSQL
		String sql ="UPDATE m_user SET"
				+ " password = ?,"
				+ " user_name = ?,"
				+ " age = ?,"
				+ " gender = ?"
				+ " WHERE"
				+ " user_id = ?";
		//一件更新
		int rowNumber=jdbc.update(sql
				,password
				,user.getUserName()
				,user.getAge()
				,user.isGender()
				,user.getUserId());
				
		return rowNumber;
	}
	
	//Userテーブルを一件削除
	@Override
	public int deleteOne(String userId) throws DataAccessException{
		return 0;
	}
	

}
