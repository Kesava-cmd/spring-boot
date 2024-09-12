package com.org.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
