/* package com.gruntech.project_management.services;

import com.gruntech.project_management.models.Employee;
import com.gruntech.project_management.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setPhone(updatedEmployee.getPhone());
            return employeeRepository.save(employee);
        }).orElseGet(() -> {
            updatedEmployee.setId(id);
            return employeeRepository.save(updatedEmployee);
        });
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    
   
} */

