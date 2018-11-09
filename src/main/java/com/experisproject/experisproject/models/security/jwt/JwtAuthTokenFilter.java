package com.experisproject.experisproject.models.security.jwt;

import com.experisproject.experisproject.models.security.services.UsersDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class JwtAuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtProvider tokenProvider;

	@Autowired
	private UsersDetailsServiceImpl userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain)
			throws ServletException, IOException {
		try {
			System.out.println(request);
			String jwt = getJwt(request);
			if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
				String username = tokenProvider.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication
						= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("Can NOT set user authentication -> Message: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	private String getJwt(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Enumeration<String> headers =   request.getHeaderNames();
		String authHeader=null;
		System.out.println(request.getHeader("cookie"));



		for(Cookie cookie:cookies){
			System.out.println(cookie);
			if(cookie.getName().equals("token")){
				authHeader=cookie.getValue();
			}
		}

		if (authHeader != null) {
			return authHeader;
		}
		return null;
	}
}