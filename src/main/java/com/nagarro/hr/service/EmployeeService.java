package com.nagarro.hr.service;

import java.util.List;

import com.nagarro.hr.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployee(int empCode);

	public void updateEmployee(Employee employee, int id);

	public void deleteEmployee();

}
