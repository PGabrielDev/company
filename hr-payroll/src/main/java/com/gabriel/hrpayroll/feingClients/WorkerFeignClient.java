package com.gabriel.hrpayroll.feingClients;

import com.gabriel.hrpayroll.Entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker",  path = "/workers")
public interface WorkerFeignClient {

     @GetMapping("/{id}")
     ResponseEntity<Worker> findById(@PathVariable Long id) throws Exception;

}
