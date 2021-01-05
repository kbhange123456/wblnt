package com.weighBridge.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.weighBridge.consumer.domain.WeighBridgeObj;
import com.weighBridge.consumer.service.WeightService;

@Component
public class WeightScheduler {
    private final WeightService weightService;

    
    WeightScheduler(WeightService greetingService) {
        this.weightService = greetingService;
    }

    @Scheduled(fixedRate = 200, initialDelayString = "25")
    public void schedulingTask() {
        weightService.sendMessages();
        System.out.println("Sending Weight");
    }
}