package com.gabriel.hrpayroll.services;
import com.gabriel.hrpayroll.Entities.Payment;
import com.gabriel.hrpayroll.Entities.Worker;
import com.gabriel.hrpayroll.feingClients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    private final WorkerFeignClient feignClient;

    public PaymentService(WorkerFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public Payment getPayment(Long workerId, int days) throws Exception {
        Worker worker = feignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
