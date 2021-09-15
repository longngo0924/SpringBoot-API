package com.example.service;

import java.util.List;

import com.example.entity.EmployeeEntity;

public interface EmployeeService {
	public void saveEmployee(EmployeeEntity entity);

	public List<EmployeeEntity> findAll();

	public void deleteEmployee(long id);
}
