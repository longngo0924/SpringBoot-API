package com.example.controller;

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

import com.example.entity.EmployeeEntity;
import com.example.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping(value = "/employee")
	public List<EmployeeEntity> getAll() {
		return service.findAll();
	}

	@PostMapping(value = "/employee")
	public String addEmployee(@RequestBody EmployeeEntity employee) {
		service.saveEmployee(employee);
		return "Success";
	}

	@PutMapping(value = "/employee/{employeeId}")
	public String updateEmployee(@RequestBody EmployeeEntity employee, @PathVariable Long employeeId) {
		employee.setId(employeeId);
		service.saveEmployee(employee);
		return "Success";
	}

	@DeleteMapping(value = "/employee/{employeeId}")
	public String deleteEmployee(@PathVariable Long employeeId) {
		try {
			service.deleteEmployee(employeeId);
			return "Deleted";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Failed";
	}

}
