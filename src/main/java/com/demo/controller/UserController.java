package com.demo.controller;

import java.util.List;

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

import com.demo.dto.UserDTO;

import service.interfaces.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService iUserService;

	@PostMapping("/create")
	public ResponseEntity<UserDTO>createUser(@RequestBody UserDTO userDTO){
		return null;
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<UserDTO>>findAll(){
		return new ResponseEntity<>(this.iUserService.findAll(),HttpStatus.OK);
	}
	
  
	@GetMapping("/find/{id}")
	public ResponseEntity<List<UserDTO>>findAllById(){
		return null;
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO>updateUser(@RequestBody UserDTO userDto,@PathVariable Integer id){
		
		return null;
	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Integer id){
		return null;
	}
}



