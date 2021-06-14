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
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.hr.model.Employee;
import com.nagarro.hr.service.EmployeeService;

@Controller
public class ActionController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/download")
	public ModelAndView exportToCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("username") == null) {
			return new ModelAndView("home");
		}
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=employee" + ".csv";
		response.setHeader(headerKey, headerValue);

		List<Employee> employees = employeeService.getAllEmployees();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "EmployeeCode", "Name", "Location", "Email", "Dob" };
		String[] nameMapping = { "employeeCode", "name", "location", "email", "dob" };

		csvWriter.writeHeader(csvHeader);

		for (Employee employee : employees) {
			csvWriter.write(employee, nameMapping);
		}

		csvWriter.close();
		return new ModelAndView("dashboard");

	}
}
