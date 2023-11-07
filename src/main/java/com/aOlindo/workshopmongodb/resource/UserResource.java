package com.aOlindo.workshopmongodb.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aOlindo.workshopmongodb.domain.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User(1, "Maria Db", "maria@gmail.com");
		User joao = new User(2, "João Silva", "joao@gmail.com");

		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, joao));

		return ResponseEntity.ok().body(list);
	}
}
