package com.example.self_healing_service.service;


import org.springframework.stereotype.Service;

@Service
public class AutoScalingService {

    // Simulate scaling up or down based on anomaly detection
    public String scaleService(boolean isAnomalyDetected) {
        if (isAnomalyDetected) {
            // Simulate scaling up (more instances needed)
            return "Scaling up! More instances are needed to handle the load.";
        } else {
            // Simulate scaling down (reducing unnecessary instances)
            return "Scaling down. Load is normal.";
        }
    }
}
