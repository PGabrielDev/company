package com.gabriel.hrpayroll.services;
import com.gabriel.hrpayroll.Entities.Payment;
import com.gabriel.hrpayroll.Entities.Worker;
import com.gabriel.hrpayroll.feingClients.WorkerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {


    private final WorkerFeignClient feignClient;
    public Payment getPayment(Long workerId, int days) throws Exception {
        Worker worker = feignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
