package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public void saveEmployee(EmployeeEntity entity) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		if (entity.getId() != null) {
			Optional<EmployeeEntity> result = repository.findById(entity.getId());
			EmployeeEntity oldEmpEntity = null;
			if (result.isPresent()) {
				oldEmpEntity = result.get();
			}
			oldEmpEntity.setAddress(entity.getAddress());
			oldEmpEntity.setEmail(entity.getEmail());
			oldEmpEntity.setGender(entity.getGender());
			oldEmpEntity.setName(entity.getName());
			employeeEntity = oldEmpEntity;
		} else {
			employeeEntity.setAddress(entity.getAddress());
			employeeEntity.setEmail(entity.getEmail());
			employeeEntity.setGender(entity.getGender());
			employeeEntity.setName(entity.getName());
		}

		repository.save(employeeEntity);
	}

	@Override
	public List<EmployeeEntity> findAll() {
		List<EmployeeEntity> list = repository.findAll();
		return list;
	}

	@Override
	public void deleteEmployee(long id) {
		if (repository.findById(id) == null) {
			return;
		}
		repository.deleteById(id);
	}

}
