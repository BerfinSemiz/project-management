package com.gruntech.project_management.controllers;

import com.gruntech.project_management.models.Customer;
import com.gruntech.project_management.services.CustomerService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Tüm müşterileri listeleyen GET isteği
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // Belirli bir müşteriyi ID’ye göre getiren GET isteği
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Yeni bir müşteri eklemek için POST isteği
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.status(201).body(savedCustomer);  // Created (201)
    }

    /* // Mevcut bir müşteriyi güncellemek için PUT isteği
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);  // OK (200)
    }
    */
    
    // Belirli bir müşteriyi silmek için DELETE isteği
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();  // No Content (204)
    }

    // Müşteri adı ile arama yapmak için GET isteği
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomersByName(@RequestParam String name) {
        List<Customer> customers = customerService.searchByName(name);
        return customers.isEmpty() 
            ? ResponseEntity.noContent().build()  // Eğer sonuç yoksa No Content döner
            : ResponseEntity.ok(customers);  // Sonuç varsa OK (200) ile döner
    }
}

