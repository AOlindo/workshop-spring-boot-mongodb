package com.aOlindo.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aOlindo.workshopmongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
