package com.nagarro.hr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hr.model.Employee;
import com.nagarro.hr.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/edit")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("username") == null) {
			return new ModelAndView("home");
		}
		int employeeCode = Integer.parseInt(request.getParameter("employeeCode"));
		String name = request.getParameter("employeeName");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		Employee employee = new Employee();
		employee.setEmployeeCode(employeeCode);
		employee.setEmail(email);
		employee.setLocation(location);
		employee.setDob(dob);
		employee.setName(name);
		employeeService.updateEmployee(employee, employee.getEmployeeCode());
		List<Employee> employees = employeeService.getAllEmployees();
		httpSession.setAttribute("employees", employees);
		return new ModelAndView("dashboard");
	}

	@RequestMapping(value = "/getAllEmployees")
	public ModelAndView getAllEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("username") != null) {
			List<Employee> employees = employeeService.getAllEmployees();
			httpSession.setAttribute("employees", employees);
			return new ModelAndView("dashboard");
		}
		return new ModelAndView("home");

	}

	@RequestMapping(value = "/getEmployee")
	public ModelAndView getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("username") != null) {
			int empCode = Integer.parseInt(request.getParameter("emp"));
			Employee employee = employeeService.getEmployee(empCode);
			httpSession.setAttribute("employee", employee);
			return new ModelAndView("edit");
		}
		return new ModelAndView("home");
	}

}
