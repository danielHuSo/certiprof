package com.tutorial.certiprof.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

	@RequestMapping(value = "/greeting", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
	public String greeting(HttpServletRequest request, Model model) {
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		
		System.out.println(firstName);
		System.out.println(middleName);
		System.out.println(lastName);

		model.addAttribute("firstName", firstName);
		model.addAttribute("middleName", middleName);
		model.addAttribute("lastName", lastName);
		return "greeting";
	}

}
