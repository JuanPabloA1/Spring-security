package com.platzi.pizza.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
			.cors().and()
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic(withDefaults());
		return http.build();
	}
}
