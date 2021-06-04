package com.serviceopolis.SpringBootMongoDBWebService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.serviceopolis.SpringBootMongoDBWebService.Domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
