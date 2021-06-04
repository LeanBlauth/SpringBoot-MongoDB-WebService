package com.serviceopolis.SpringBootMongoDBWebService.Config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.serviceopolis.SpringBootMongoDBWebService.Domain.Post;
import com.serviceopolis.SpringBootMongoDBWebService.Domain.User;
import com.serviceopolis.SpringBootMongoDBWebService.Repository.PostRepository;
import com.serviceopolis.SpringBootMongoDBWebService.Repository.UserRepository;

@Configuration
public class Instantiation  implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User rudolph = new User(null, "Rudolph Reindeer", "rudy@gmail.com");
		User plumbus = new User(null, "Plumbus Gorgonoid", "gorgon@gmail.com");
		User uranus = new User(null, "Uranus Darlington", "uranus@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "It's so coooldd !", "It's so cold my hooves are freezing", rudolph);
		Post post2 = new Post(null, sdf.parse("14/11/2035"), "where is my pizza", "It has been 2 hours already I'm hungry you know", plumbus);
		
		userRepo.saveAll(Arrays.asList(rudolph, plumbus, uranus));
		postRepo.saveAll(Arrays.asList(post1, post2));
	}

}
