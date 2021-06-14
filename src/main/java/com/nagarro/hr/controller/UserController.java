package com.nagarro.hr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hr.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/Login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession httpSession = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (!userService.isUserValid(username, password)) {

		}
		httpSession.setAttribute("username", username);
		System.out.println("username:" + username);
		response.sendRedirect("getAllEmployees");
	}

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/Logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("username");
		return new ModelAndView("home");
	}

	
	
}