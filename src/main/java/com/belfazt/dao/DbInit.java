package com.belfazt.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.belfazt.model.User;


@Service
public class DbInit implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User mani = new User("mani", bCryptPasswordEncoder.encode("mani123"), 0, "USER", "");
		User admin = new User("admin", bCryptPasswordEncoder.encode("admin123"), 0, "ADMIN", "ACCESS_API_DATA_1,ACCESS_API_DATA_2");
		User manager = new User("manager", bCryptPasswordEncoder.encode("manager123"), 0, "MANAGER", "ACCESS_API_DATA_1");
		List<User> users = new ArrayList<User>();
		users.add(mani);
		users.add(admin);
		users.add(manager);
		userRepository.saveAll(users);
	}
	
}
