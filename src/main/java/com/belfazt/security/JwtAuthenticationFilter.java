package com.belfazt.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.belfazt.dao.UserRepository;
import com.belfazt.services.CustomUserDetailService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			
			String jwt = getJwtFromRequest(request);
			if(jwt != null && jwtTokenProvider.validateToken(jwt)) {
				String username = jwtTokenProvider.getUsernameFromToken(jwt);
				UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
				
				
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, Collections.emptyList()		
				);
				
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				
			}
			
		}catch (Exception e) {
			System.err.println("cannot set user authentication");
		}
		
		filterChain.doFilter(request, response);
		
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		
		String jwt = request.getHeader("Authorization");
		
		if(StringUtils.hasText(jwt) && jwt.startsWith("Bearer")) {
			return jwt.substring(7);
		}
		return null;
	}
	
	
}