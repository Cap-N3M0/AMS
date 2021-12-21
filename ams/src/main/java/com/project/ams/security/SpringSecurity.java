package com.project.ams.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.accept.ContentNegotiationStrategy;

import com.project.ams.repository.UserLoginRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private DataSource dataSource;
//  TODO: This is working fine. just remove commnent     
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//            .dataSource(dataSource)	
//            .usersByUsernameQuery("select username, password, enabled from user_login where username=?")
//            .authoritiesByUsernameQuery("select email, role from users where email=?")
//        ;
//    }
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.antMatcher("/home").authorizeRequests().anyRequest().authenticated()
		.and()
        .csrf().disable()
        
		.formLogin()
	      .loginPage("/home")
	      .loginProcessingUrl("/userHome")
	      .defaultSuccessUrl("/userHome",true)
	      .failureUrl("/home?error=true")
	      ;
	}

}
