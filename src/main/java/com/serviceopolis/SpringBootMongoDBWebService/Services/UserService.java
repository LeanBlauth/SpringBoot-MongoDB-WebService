package com.serviceopolis.SpringBootMongoDBWebService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceopolis.SpringBootMongoDBWebService.Domain.User;
import com.serviceopolis.SpringBootMongoDBWebService.Repository.UserRepository;
import com.serviceopolis.SpringBootMongoDBWebService.Services.Exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String Id) {
		Optional<User> obj = repo.findById(Id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

}
