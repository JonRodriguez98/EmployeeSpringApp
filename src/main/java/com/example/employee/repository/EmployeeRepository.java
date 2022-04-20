package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { //this allows Spring JPA to identify the table structure and know how to access individual entities
	//in the table through the Primary Key datatype. Allowing us to use simple CRUD methods to access the database.

}
