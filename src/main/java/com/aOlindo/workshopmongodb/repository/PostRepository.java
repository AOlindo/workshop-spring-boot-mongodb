package com.aOlindo.workshopmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aOlindo.workshopmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContainingIgnoreCase(String text);
}
