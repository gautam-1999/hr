package com.nagarro.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.hr.dao.EmployeeDao;
import com.nagarro.hr.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = employeeDao.getAllEmployees();
		return list;
	}

	@Override
	public Employee getEmployee(int empCode) {

		Employee employee = employeeDao.getEmployee(empCode);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee, int id) {
		employeeDao.updateEmployee(employee, id);

	}

	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub

	}

}
