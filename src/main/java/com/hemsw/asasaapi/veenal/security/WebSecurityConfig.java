package com.hemsw.asasaapi.veenal.security;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig
{ // extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

//	@Autowired
//	private AuthEntryPoint unauthorizedHandler;
	@Bean
	public AuthTokenFilter authTokenFilter()
	{
		return new AuthTokenFilter();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception
	{
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		//		http.csrf(csrf -> csrf.disable())
		//				.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
		//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		//				.authorizeHttpRequests(auth
		//						-> auth.requestMatchers("/api/auth/**").permitAll()
		//						.requestMatchers("/api/test/**").permitAll()
		//						.requestMatchers("/check_auth/**").permitAll()
		//						.anyRequest().authenticated()
		//				);
		//				.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
		//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

		return http
				.cors(Customizer.withDefaults())
				.authorizeHttpRequests(auth
						-> auth
						.requestMatchers("/login").permitAll()
						.requestMatchers("/test/**").permitAll()
						.anyRequest().authenticated()
				)
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class)
				.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()))
				.csrf((csrf) -> csrf.disable())
				.build();

//		http.cors((cors) -> cors.disable());
//		http
//		http.authenticationProvider(authenticationProvider());
//		http.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource()
	{
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(
				"http://127.0.0.1:3000",
				"http://127.0.0.1:3000/",
				"http://localhost:3000",
				"http://localhost:3000/",
				"http://veenal.asasa.hemsw.com//",
				"https://veenal.asasa.hemsw.com//",
				"*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "CONNECT", "TRACE"));
		configuration.setAllowedHeaders(Arrays.asList(
				"Accept",
				"Accept-Encoding",
				"Accept-Language",
				"Access-Control-Request-Headers",
				"Access-Control-Request-Method",
				"Access-Control-Allow-Origin",
				"Authorization",
				"Connection",
				"Host",
				"Origin",
				"Referer",
				"Content-Type",
				"X-Requested-With",
				"*"
		));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

//	CorsWebFilter corsFilter()
	//@Bean
	/*
	CorsConfigurationSource ___corsConfigurationSource()
	{
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));

		CorsConfigurationSource source = new CorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return (CorsConfigurationSource) source;
	}
	//@Bean
	CorsConfigurationSource corsConfigurationSource1()
	{
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(List.of("Authorization"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return (CorsConfigurationSource) source;
	}
	 */
}
