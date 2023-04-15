package com.tutorial.certiprof.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tutorial.certiprof.model.User;
import com.tutorial.certiprof.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/getall", produces= {"application/json"})
	public ResponseEntity<List<User>> getAllUsers() throws JsonParseException, JsonMappingException, IOException {
		
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
		
	}
	

	@GetMapping(value="/get/{id}", produces= {"application/json"})
	public ResponseEntity<User> getById(@PathVariable String id) throws JsonParseException, JsonMappingException, IOException {
		
		return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
		
	}

}
