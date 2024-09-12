package com.org.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.employee.dto.CreateEmployeeRequest;
import com.org.employee.dto.UpdateEmployeeRequest;
import com.org.employee.entity.Employee;
import com.org.employee.repos.EmployeeRepository;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeRepository.findById(id).get();
	}
	
	@PostMapping("/employee")
	@Transactional
	public Employee saveEmployee(@RequestBody CreateEmployeeRequest request) {
		Employee employee = new Employee();
		employee.setId(request.getId());
		employee.setFirstName(request.getEmployeeFirstName());
		employee.setLastName(request.getEmployeeLastName());
		employee.setMiddleName(request.getEmployeeMiddleName());
		employee.setEmail(request.getEmployeeEmail());
		employee.setPhone(request.getEmployeePhone());
		employee.setCity(request.getEmployeeCity());

		return employeeRepository.save(employee);
	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody UpdateEmployeeRequest request) {
		Employee emp = employeeRepository.findById(request.getId()).get();

		emp.setEmail(request.getEmployeeEmail());
		emp.setPhone(request.getEmployeePhone());

		return employeeRepository.save(emp);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);

	}
}
