//this class provides/executes the business logic on the tables

package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

     							//dependency of the Service. Basically In order for the Service to do what it can do it needs to be able to access the database 
			@Autowired 			//and the database is accessed through the EmployeeRepository class which allows Spring JPA to access the table structure.
            EmployeeRepository empRepository;    
        
        //The following methods are able to be accessed because of the dependency above which is extending JpaRepository that has these built in methods.
        
        // CREATE 
        public Employee createEmployee(Employee emp) {
            return empRepository.save(emp);
        }

        // READ
        public List<Employee> getEmployees() {
            return empRepository.findAll();
        }

        // DELETE
        public void deleteEmployee(Long empId) {
            empRepository.deleteById(empId);
        }

     // UPDATE
        public Employee updateEmployee(Long empId, Employee employeeDetails) {
                Employee emp = empRepository.findById(empId).get();
                emp.setFirstName(employeeDetails.getFirstName());
                emp.setLastName(employeeDetails.getLastName());
                emp.setEmailId(employeeDetails.getEmailId());
                
                return empRepository.save(emp);                                
        }

}
