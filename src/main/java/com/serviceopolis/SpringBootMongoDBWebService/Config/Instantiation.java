package com.serviceopolis.SpringBootMongoDBWebService.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.serviceopolis.SpringBootMongoDBWebService.Domain.User;
import com.serviceopolis.SpringBootMongoDBWebService.Repository.UserRepository;

@Configuration
public class Instantiation  implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepo.deleteAll();
		
		User rudolph = new User(null, "Rudolph Reindeer", "rudy@gmail.com");
		User plumbus = new User(null, "Plumbus Gorgonoid", "gorgon@gmail.com");
		User uranus = new User(null, "Uranus Darlington", "uranus@gmail.com");
		
		userRepo.saveAll(Arrays.asList(rudolph, plumbus, uranus));
	}

}
