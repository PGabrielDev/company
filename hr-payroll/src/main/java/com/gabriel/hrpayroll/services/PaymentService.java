package com.gabriel.hrpayroll.services;
import com.gabriel.hrpayroll.Entities.Payment;
import com.gabriel.hrpayroll.Entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${hr-worker-URI}")
    private  String uri;
    private final RestTemplate restTemplate;
    public Payment getPayment(Long workerId, int days){
        Map<String, String> map = new HashMap<>();
        map.put("id", workerId.toString());
        Worker worker = restTemplate.getForObject(uri + "/workers/{id}", Worker.class, map);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
