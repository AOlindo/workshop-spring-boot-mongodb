package com.aOlindo.workshopmongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aOlindo.workshopmongodb.domain.Post;
import com.aOlindo.workshopmongodb.domain.User;
import com.aOlindo.workshopmongodb.dto.AtualizaUserDTO;
import com.aOlindo.workshopmongodb.dto.CadastroUserDTO;
import com.aOlindo.workshopmongodb.repository.PostRepository;
import com.aOlindo.workshopmongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
}
