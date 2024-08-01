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
		return new ResponseEntity<>(this.iUserService.createUser(userDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<UserDTO>>findAll(){
		return new ResponseEntity<>(this.iUserService.findAll(),HttpStatus.OK);
	}
	
  
	@GetMapping("/find/{id}")
	public ResponseEntity<UserDTO>findlById(@PathVariable Integer id){
		return new ResponseEntity<>(this.iUserService.findById(id), HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO>updateUser(@RequestBody UserDTO userDTO,@PathVariable Integer id){
		
		return new ResponseEntity<>(this.iUserService.updateUser(userDTO,id), HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Integer id){
		return new ResponseEntity<>(this.iUserService.deleteUser(id),HttpStatus.NO_CONTENT);
	}
}



