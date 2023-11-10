package com.aOlindo.workshopmongodb.resource;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aOlindo.workshopmongodb.domain.Post;
import com.aOlindo.workshopmongodb.dto.PostDTO;
import com.aOlindo.workshopmongodb.resource.util.URL;
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
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text") String text){
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/fullSearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text", defaultValue="") String text,
			@RequestParam(value = "minDate", defaultValue="") String minDate,
			@RequestParam(value = "maxDate", defaultValue="") String maxDate){
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());//pega a data atual 
		List<Post> list = postService.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
		
	}

	
	
	
	
	
	
	}
	
	

