package com.example.demo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //デフォルトのwebセキュリティ設定をオフにしますよ
@Configuration //設定用のクラスですよ
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(WebSecurity web) throws Exception{
		//静的リソースへのアクセスには、セキュリティを適用しない
		web.ignoring().antMatchers("/webjars/**","/css/**");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//ログイン不要ページの設定
		http.authorizeRequests()
			.antMatchers("/webjars/**").permitAll()//webjarsへアクセス許可
			.antMatchers("/css/**").permitAll()//cssへアクセス許可
			.antMatchers("/images/**").permitAll()
			.antMatchers("/login").permitAll() //ログインページは直リンクOK
			.antMatchers("/signup").permitAll() //ユーザー登録画面は直リンクOK
			.antMatchers("/home").permitAll()//ホーム画面は直リンクOK
			.anyRequest().authenticated(); //それ以外は直リンク禁止
	
	//ログイン処理
	http.formLogin().loginProcessingUrl("/login")//ログイン処理のパス
					.loginPage("/login") //ログインページの指定、これがないとデフォルトのセキュリティページになってしまう
					.failureUrl("/login") //ログイン失敗時の遷移先
					.usernameParameter("userId") //ログインページのユーザーID
					.passwordParameter("password") //ログインページのユーザーID
					.defaultSuccessUrl("/home",true); //ログイン成功後の遷移先
	//CSRF対策を無効に設定（一時的）
	http.csrf().disable();
	}
}
