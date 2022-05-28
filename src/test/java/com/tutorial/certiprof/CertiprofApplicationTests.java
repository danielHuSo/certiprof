package com.tutorial.certiprof;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.tutorial.certiprof.controller.GreetingController;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CertiprofApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CertiprofApplicationTests {

	 
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;   

    @InjectMocks
    private GreetingController greetingController;

	@Test
	public void greetingTest() {		

        when(request.getParameter("firstName")).thenReturn("Julio");
        when(request.getParameter("lastName")).thenReturn("Gomez");
        Model model = new ExtendedModelMap();
        
        String result = greetingController.greeting(request, model);
        
        assertEquals("greeting11111", result);
	}

}
