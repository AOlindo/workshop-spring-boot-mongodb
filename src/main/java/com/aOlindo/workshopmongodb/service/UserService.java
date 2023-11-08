package com.aOlindo.workshopmongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aOlindo.workshopmongodb.domain.User;
import com.aOlindo.workshopmongodb.dto.AtualizaUserDTO;
import com.aOlindo.workshopmongodb.dto.CadastroUserDTO;
import com.aOlindo.workshopmongodb.repository.UserRepository;
import com.aOlindo.workshopmongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
		return user;
	}
	
	public User insert(CadastroUserDTO userDto) {
		User user = new User(userDto);
		return userRepository.save(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(AtualizaUserDTO atualizaDto, String id) {
		User user = findById(id);
		user.atualiza(atualizaDto);
		return userRepository.save(user);
		
	}
}
