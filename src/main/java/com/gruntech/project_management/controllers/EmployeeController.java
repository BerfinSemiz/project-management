/* package com.gruntech.project_management.controllers;

import com.gruntech.project_management.models.Employee;
import com.gruntech.project_management.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Tüm çalışanları listeleyen GET isteği
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Belirli bir çalışanı ID’ye göre getiren GET isteği
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Yeni bir çalışan eklemek için POST isteği
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(201).body(createdEmployee);  // Created (201)
    }

    // Mevcut bir çalışanı güncellemek için PUT isteği
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);  // OK (200)
    }

    // Belirli bir çalışanı silmek için DELETE isteği
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();  // No Content (204)
    }

    // Çalışan adı ile arama yapmak için GET isteği
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam String name) {
        List<Employee> employees = employeeService.searchByName(name);
        return employees.isEmpty() 
            ? ResponseEntity.noContent().build()  // Eğer sonuç yoksa No Content döner
            : ResponseEntity.ok(employees);  // Sonuç varsa OK (200) ile döner
    }
}
*/