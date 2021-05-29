package com.serviceopolis.SpringBootMongoDBWebService.Resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.serviceopolis.SpringBootMongoDBWebService.Domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User rudolph = new User("1", "Rudolph Reindeer", "rudy@gmail.com");
		User plumbus = new User("2", "Plumbus Gorgonzoid", "gorgon@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(rudolph, plumbus));
		return ResponseEntity.ok().body(list);
	}

}
