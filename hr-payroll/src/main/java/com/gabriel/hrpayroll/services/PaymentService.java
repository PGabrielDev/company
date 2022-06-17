package com.gabriel.hrpayroll.services;
import com.gabriel.hrpayroll.Entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return new Payment("Eduardo",900.0,days);
    }

}
