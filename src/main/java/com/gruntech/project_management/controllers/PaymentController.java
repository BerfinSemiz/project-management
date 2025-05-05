/* package com.gruntech.project_management.controllers;

import com.gruntech.project_management.models.Payment;
import com.gruntech.project_management.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Bu sınıf, ödemelerle ilgili REST API isteklerini yöneten Controller sınıfıdır.
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    // PaymentService sınıfını controller'a otomatik olarak enjekte ediyoruz
    @Autowired
    private PaymentService paymentService;

    // Tüm ödeme kayıtlarını getiren GET isteği
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Belirli bir ödemeyi ID’ye göre getiren GET isteği
    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // Yeni bir ödeme eklemek için POST isteği
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    // Mevcut bir ödemeyi güncelleyen PUT isteği
    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    // Belirli bir ödemeyi silmek için DELETE isteği
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
*/