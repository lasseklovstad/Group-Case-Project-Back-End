package com.experisproject.experisproject;

import com.experisproject.experisproject.models.security.jwt.JwtAuthEntryPoint;
import com.experisproject.experisproject.models.security.jwt.JwtAuthTokenFilter;
import com.experisproject.experisproject.models.security.services.UsersDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		UsersDetailsServiceImpl userDetailsService;

		@Autowired
		private JwtAuthEntryPoint unauthorizedHandler;

		@Bean
		public JwtAuthTokenFilter authenticationJwtTokenFilter() {
			return new JwtAuthTokenFilter();
		}

		@Override
		public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
			authenticationManagerBuilder
					.userDetailsService(userDetailsService)
					.passwordEncoder(passwordEncoder());
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable()
					.authorizeRequests()
						.antMatchers("/api/auth/**").permitAll()
						.and().authorizeRequests().antMatchers(HttpMethod.GET,"/api/player/all").permitAll()
						.and().authorizeRequests().antMatchers(HttpMethod.GET,"/api/teamResult/homeTeam").permitAll()
					.and().authorizeRequests().antMatchers(HttpMethod.GET,"/api/teamResult/awayTeam").permitAll()
						.anyRequest().authenticated()

					.and()
					.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

			http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		}
}
