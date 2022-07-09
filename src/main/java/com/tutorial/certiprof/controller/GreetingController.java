package com.tutorial.certiprof.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

    public static final Logger LOGGER = LogManager.getLogger(GreetingController.class);

	@RequestMapping(value = "/greeting", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
	public String greeting(HttpServletRequest request, Model model) {
	    
		LOGGER.info("Este es un registro de bitacora");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String birthDate = request.getParameter("birthDate");

		model.addAttribute("firstName", firstName);
		model.addAttribute("middleName", middleName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("birthDate", birthDate);
		return "greeting";
	}

}
