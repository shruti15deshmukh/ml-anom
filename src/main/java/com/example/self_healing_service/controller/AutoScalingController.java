package com.example.self_healing_service.controller;

import com.example.self_healing_service.service.AnomalyDetectionService;
import com.example.self_healing_service.service.AutoScalingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoScalingController {

    @Autowired
    private AnomalyDetectionService anomalyDetectionService;

    @Autowired
    private AutoScalingService autoScalingService;

    @GetMapping("/auto-scale")
    public String autoScale(@RequestParam double responseTime) {
        boolean isAnomaly = anomalyDetectionService.detectAnomaly(responseTime);
        return autoScalingService.scaleService(isAnomaly);
    }
}
