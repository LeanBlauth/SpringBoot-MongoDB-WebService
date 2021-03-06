package com.serviceopolis.SpringBootMongoDBWebService.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceopolis.SpringBootMongoDBWebService.Domain.Post;
import com.serviceopolis.SpringBootMongoDBWebService.Repository.PostRepository;
import com.serviceopolis.SpringBootMongoDBWebService.Services.Exception.ObjectNotFoundException;

@Service
public class PostService {
	
	private static final int twentyfourhours = 24 * 60 * 60 * 1000;
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String Id) {
		Optional<Post> obj = repo.findById(Id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text) {
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + twentyfourhours);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
