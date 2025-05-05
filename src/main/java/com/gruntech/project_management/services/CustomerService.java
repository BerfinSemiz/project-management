package com.gruntech.project_management.services;

import com.gruntech.project_management.models.Customer;
import com.gruntech.project_management.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Tüm müşterileri getir
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Yeni müşteri kaydet
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // ID'ye göre müşteri getir
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Müşteri sil
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // public Customer updateCustomer(Long id, Customer updatedCustomer) {
    //     return customerRepository.findById(id).map(customer -> {
    //         customer.setName(updatedCustomer.getName());
    //         customer.setEmail(updatedCustomer.getEmail());
    //         customer.setPhone(updatedCustomer.getPhone());
    //         return customerRepository.save(customer);
    //     }).orElseGet(() -> {
    //         updatedCustomer.setId(id);
    //         return customerRepository.save(updatedCustomer);
    //     });
    // }

    public List<Customer> searchByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }
}
