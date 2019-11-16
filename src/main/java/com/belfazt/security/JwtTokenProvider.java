package com.belfazt.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
	
	public String generateToken(Authentication authentication) {
		UserPrincipal userDetails = (UserPrincipal)authentication.getPrincipal();
		Date now = new Date();
		
		Date expiryDate = new Date(now.getTime() + 3000000);	//Expiration time 50mins in ms
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("id", Long.toString(userDetails.getId()));
		claims.put("username", userDetails.getUsername());
		
		return Jwts.builder()
				.setSubject(Long.toString(userDetails.getId()))
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, "SECRET")	//"SECRET" is the signature secret key
				.compact();
	}
	
	public boolean validateToken(String jwt) {
		
		try {
			Jwts.parser().setSigningKey("SECRET").parseClaimsJws(jwt);
			return true;
		}catch (SignatureException e) {
			System.err.println("Invalid jwt signature");
		}catch (MalformedJwtException e) {
			System.err.println("Invalid jwt signature");
		}catch (ExpiredJwtException e) {
			System.err.println("Expired jwt token");
		}catch (UnsupportedJwtException e) {
			System.err.println("Unsupported jwt token");
		}catch (IllegalArgumentException e) {
			System.err.println("JWT claim string is empty");
		}
		return false;
	}
	
	public String getUsernameFromToken(String jwt) {
		Claims claims = Jwts.parser().setSigningKey("SECRET").parseClaimsJws(jwt).getBody();
		return (String)claims.get("username");
	}
}
