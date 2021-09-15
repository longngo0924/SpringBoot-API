package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
