package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.feignClient.WorkerFeignClient;
import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    //Com restTemplate
//    public Payment getPayment(long workerId, int days) {
//        String url = workerHost + "/workers/" + workerId;
//
//        Worker worker = restTemplate.getForObject(url, Worker.class);
//        return new Payment(worker.getName(), worker.getDailyIncome(), days);
//    }
}
