/* package com.gruntech.project_management.services;

import com.gruntech.project_management.models.Payment;
import com.gruntech.project_management.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        return paymentRepository.findById(id).map(payment -> {
            payment.setAmount(updatedPayment.getAmount());
            payment.setPaymentDate(updatedPayment.getPaymentDate());
            payment.setStatus(updatedPayment.getStatus());
            payment.setProject(updatedPayment.getProject());
            return paymentRepository.save(payment);
        }).orElseGet(() -> {
            updatedPayment.setId(id);
            return paymentRepository.save(updatedPayment);
        });
    }
} */
