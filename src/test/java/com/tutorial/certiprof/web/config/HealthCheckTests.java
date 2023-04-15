package com.tutorial.certiprof.web.config;

import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.certiprof.CertiprofApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CertiprofApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthCheckTests {

	 
    @InjectMocks
    private HealthCheck healthCheck;

	@Test
	public void healthCheckTest() {		
        
		ResponseEntity<String> result = healthCheck.home(Locale.US);
        
        assertNotNull(result.getBody());
	}

}
