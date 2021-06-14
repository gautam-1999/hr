package com.nagarro.hr.dao;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import com.nagarro.hr.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();

		String result = restTemplate.getForObject("http://localhost:8082/employees", String.class);
		List<Employee> employees = null;
		try {
			employees = (List<Employee>) mapper.readValue(result,
					mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployee(int empCode) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/employees/{id}";
		Employee employee = restTemplate.getForObject(url, Employee.class, empCode);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee, int id) {

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/employees/{id}";
		restTemplate.put(url, employee, id);
	}

	

}
