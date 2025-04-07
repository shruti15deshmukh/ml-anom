package com.example.self_healing_service.service;


import org.springframework.stereotype.Service;

@Service
public class AnomalyDetectionService {

    // Simulate an anomaly detection logic (simple threshold)
    public boolean detectAnomaly(double responseTime) {
        // Example threshold for slow responses (in ms)
        double threshold = 150.0;
        return responseTime > threshold;  // If response time exceeds threshold, it's an anomaly
    }
}
