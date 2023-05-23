package com.tutorial.certiprof.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tutorial.certiprof.CertiprofApplication;
import com.tutorial.certiprof.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CertiprofApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTests {
	

    @InjectMocks
    private UserService userService; 
    
	@Test
	public void getAllTest() throws JsonParseException, JsonMappingException, IOException {				
   
        List<User> result = userService.getAllUser();        
        assertNotNull(result);
	}  
    
	@Test
	public void getById() throws JsonParseException, JsonMappingException, IOException {				
   
        User result = userService.getById("1");        
        assertNotNull(result);
	}  
    
	@Test
	public void getById_WhenNull() throws JsonParseException, JsonMappingException, IOException {				
   
        User result = userService.getById("10");        
        assertNull(result);
	}  

}
