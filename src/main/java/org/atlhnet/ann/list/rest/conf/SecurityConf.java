package org.atlhnet.ann.list.rest.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("rputoa").password("test")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("test")
				.roles("USER");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// .antMatchers("/resources/**", "/src/**", "/#/**").permitAll()
		// .anyRequest().authenticated().and().formLogin().and()
		// .httpBasic();
				.anyRequest().permitAll();
	}

}
