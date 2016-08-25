package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class FareyeFormsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FareyeFormsApplication.class, args);
	}
	@Configuration
	class MvcConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("../static/home");
			//registry.addViewController("/index").setViewName("../static/index");
			registry.addViewController("/login").setViewName("login");
		}

	}

	@Configuration
	@EnableWebSecurity
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {


		@Autowired
		UserDetailsService userDetailsService;
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
					.antMatchers("/prefixfree.min.js").permitAll()
					.antMatchers("/wall.jpg").permitAll()
					.and()
					.authorizeRequests()
					.antMatchers("/createForm","/addAttribute","/createUser").hasAuthority("admin")
                    .antMatchers("/getFormAttribute","/getForm","/displayRecord","/insertTransaction","/getuser").hasAnyAuthority("admin","user")
                    .and()
					.authorizeRequests()
					.anyRequest().authenticated()
					.and()
					.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
					.logout()
					.permitAll()
					.and().csrf().disable();
			http.userDetailsService(userDetailsService());
		}
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

			auth.userDetailsService(userDetailsService());

		}

		@Override
		protected UserDetailsService userDetailsService() {
			return userDetailsService;
		}


	}
}
