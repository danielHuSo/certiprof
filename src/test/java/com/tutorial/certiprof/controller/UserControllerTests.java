package com.tutorial.certiprof.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tutorial.certiprof.CertiprofApplication;
import com.tutorial.certiprof.model.User;
import com.tutorial.certiprof.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CertiprofApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTests {
	

    @InjectMocks
    private UserController userController;
    
    @Mock
    private UserService userService;    
    
	@Test
	public void getAllTest() throws JsonParseException, JsonMappingException, IOException {		
		
		List<User> users = new ArrayList<>();
		User user = new User();		
		user.setName("Daniel");
		user.setLastName("Huerta");
		user.setId("1");
		user.setAddress("MX");
		user.setBirthDate("01/01/2020");
		users.add(user);
		

		when(userService.getAllUser()).thenReturn(users);        
        ResponseEntity<List<User>> result = userController.getAllUsers();        
        assertNotNull(result);
	}  
    
	@Test
	public void getByIdTest() throws JsonParseException, JsonMappingException, IOException {
		
		User user = new User();		
		user.setName("Daniel");
		user.setLastName("Huerta");
		user.setId("1");
		user.setAddress("MX");
		user.setBirthDate("01/01/2020");

		when(userService.getById("1")).thenReturn(user);
        
        ResponseEntity<User> result = userController.getById("1");
        
        assertNotNull(result);
        assertEquals("Daniel", user.getName());
        assertEquals("Huerta", user.getLastName());
        assertEquals("01/01/2020", user.getBirthDate());
        assertEquals("MX", user.getAddress());
	}

}
