package com.nagarro.hr.dao;

import java.util.List;

import com.nagarro.hr.model.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployees();

	public Employee getEmployee(int empCode);

	public void updateEmployee(Employee employee, int id);

}
