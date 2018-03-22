package com.cmautomation.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class CMAppSecurityConfig extends WebSecurityConfigurerAdapter {
	//add a reference to the security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers("/").access("hasRole('USER')")
		.antMatchers("/cma/**").hasAnyRole("CMA","QA","TSA")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/qa/**").hasRole("QA")
		.antMatchers("/tsa/**").hasRole("TSA")
		//.anyRequest().authenticated()
		
		
		/*.antMatchers("/application/showForm*").hasAnyRole("ADMIN")
		.antMatchers("/application/save*").hasAnyRole("ADMIN")
		.antMatchers("/application/delete").hasRole("ADMIN")
		.antMatchers("/application/**").hasRole("USER")
		.antMatchers("/resources/**").permitAll()
		*/
		.and()
			.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateTheUser").permitAll()
			.and().logout().permitAll()
			.and().exceptionHandling().accessDeniedPage("/access-denied");
	}

}
