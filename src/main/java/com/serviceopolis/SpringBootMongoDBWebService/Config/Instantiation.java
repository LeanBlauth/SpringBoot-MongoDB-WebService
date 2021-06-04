package com.serviceopolis.SpringBootMongoDBWebService.Config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.serviceopolis.SpringBootMongoDBWebService.DTO.AuthorDTO;
import com.serviceopolis.SpringBootMongoDBWebService.DTO.CommentDTO;
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
		
		userRepo.saveAll(Arrays.asList(rudolph, plumbus, uranus));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "It's so coooldd BAA !", "It's so cold my hooves are freezing", new AuthorDTO(rudolph));
		Post post2 = new Post(null, sdf.parse("14/11/2035"), "where is my pizza", "It has been 2 hours already I'm hungry you know", new AuthorDTO(plumbus));
		
		CommentDTO c1 = new CommentDTO("Dont't forget your hooves' boots !", sdf.parse("22/03/2035"), new AuthorDTO(uranus));
		CommentDTO c2 = new CommentDTO("Damn it happened to me last week it pisses me off !", sdf.parse("14/11/2035"), new AuthorDTO(rudolph));
		CommentDTO c3 = new CommentDTO("Poor Rudolph T___T", sdf.parse("22/03/2035"), new AuthorDTO(plumbus));
		
		post1.getComments().addAll(Arrays.asList(c1, c3));
		post2.getComments().addAll(Arrays.asList(c2));
		
		postRepo.saveAll(Arrays.asList(post1, post2));
		
		rudolph.getPosts().addAll(Arrays.asList(post1));
		plumbus.getPosts().addAll(Arrays.asList(post2));
		userRepo.saveAll(Arrays.asList(rudolph, plumbus));
	}

}
