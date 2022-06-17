package com.gabriel.hrpayroll.controller;

import com.gabriel.hrpayroll.Entities.Payment;
import com.gabriel.hrpayroll.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayments(@PathVariable Long workerId, @PathVariable Integer days) throws Exception {
        return ResponseEntity.ok(service.getPayment(workerId,days));
    }

}
