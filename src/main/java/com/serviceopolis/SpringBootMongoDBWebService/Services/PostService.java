package com.serviceopolis.SpringBootMongoDBWebService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceopolis.SpringBootMongoDBWebService.Domain.Post;
import com.serviceopolis.SpringBootMongoDBWebService.Repository.PostRepository;
import com.serviceopolis.SpringBootMongoDBWebService.Services.Exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String Id) {
		Optional<Post> obj = repo.findById(Id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}
