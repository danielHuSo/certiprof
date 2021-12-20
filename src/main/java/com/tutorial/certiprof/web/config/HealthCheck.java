package com.tutorial.certiprof.web.config;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
	
	@Value("${app.version}")
	private String version;
	
	@GetMapping("/health")
	public ResponseEntity<String> home(Locale locale) {
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(new Date());
		String mensaje = "Welcome,  health check version: " + version;
		
		return new ResponseEntity<>(mensaje + "   " +formattedDate, HttpStatus.OK);
	}

}
