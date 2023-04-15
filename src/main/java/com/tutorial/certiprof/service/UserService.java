package com.tutorial.certiprof.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.certiprof.model.User;

@Service
public class UserService {
	
	
	public String getJsonFromFileResource() {
		
		InputStream inputStream = this.getClass().getResourceAsStream("/db/users.json");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		Stream<String> lines = bufferedReader.lines();
		return lines.collect(Collectors.joining());
		
	}
	
	private Object parseJson2ObjectList(String json, Class<?> c) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class,  c));
	}

	public List<User> getAllUser() throws JsonParseException, JsonMappingException, IOException {
		String json = getJsonFromFileResource();
		
		return (List<User>) parseJson2ObjectList(json, User.class);
	}
	


	public User getById(String id) throws JsonParseException, JsonMappingException, IOException {
		String json = getJsonFromFileResource();
		
		List<User> users = (List<User>) parseJson2ObjectList(json, User.class);
		
		return users.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
	}
}
