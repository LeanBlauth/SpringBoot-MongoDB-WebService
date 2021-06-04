package com.serviceopolis.SpringBootMongoDBWebService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceopolis.SpringBootMongoDBWebService.DTO.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String Id) {
		findById(Id); // Throw 404 if not found
		repo.deleteById(Id);
	} 
	
	// Declared here instead of in the UserDTO class because the service has access to the database.
	// This way it is possible to perform maintenance through data access
	public User fromDTO(UserDTO dtoObj) {
		return new User(dtoObj.getId(), dtoObj.getName(), dtoObj.getEmail());
	}

}
