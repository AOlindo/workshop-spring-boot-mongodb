package com.aOlindo.workshopmongodb.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aOlindo.workshopmongodb.domain.User;
import com.aOlindo.workshopmongodb.dto.AtualizaUserDTO;
import com.aOlindo.workshopmongodb.dto.CadastroUserDTO;
import com.aOlindo.workshopmongodb.dto.UserDTO;
import com.aOlindo.workshopmongodb.service.UserService;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> listDto = userService.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody CadastroUserDTO user){
		 userService.insert(user);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody AtualizaUserDTO atualizaDto){
		userService.update(atualizaDto, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
