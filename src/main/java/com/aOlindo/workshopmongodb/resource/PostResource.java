package com.aOlindo.workshopmongodb.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aOlindo.workshopmongodb.domain.Post;
import com.aOlindo.workshopmongodb.domain.User;
import com.aOlindo.workshopmongodb.dto.AuthorDTO;
import com.aOlindo.workshopmongodb.dto.PostDTO;
import com.aOlindo.workshopmongodb.dto.UserDTO;
import com.aOlindo.workshopmongodb.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll() {
		List<Post> list = postService.findAll();
		List<PostDTO> listDto = postService.findAll().stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(new PostDTO(obj));
	}
	
	
	}
	
	

