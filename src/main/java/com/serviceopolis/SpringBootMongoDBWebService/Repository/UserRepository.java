package com.serviceopolis.SpringBootMongoDBWebService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.serviceopolis.SpringBootMongoDBWebService.Domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
