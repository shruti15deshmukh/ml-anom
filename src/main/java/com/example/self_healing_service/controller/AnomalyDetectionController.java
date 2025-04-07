package com.example.self_healing_service.controller;


import com.example.self_healing_service.service.AnomalyDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnomalyDetectionController {

    @Autowired
    private AnomalyDetectionService anomalyDetectionService;

    @GetMapping("/detect-anomaly")
    public String detectAnomaly(@RequestParam double responseTime) {
        boolean isAnomaly = anomalyDetectionService.detectAnomaly(responseTime);
        return isAnomaly ? "Anomaly detected!" : "No anomaly detected.";
    }
}
