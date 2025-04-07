package com.example.self_healing_service.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringController.class);

    @GetMapping("/health-check")
    public String healthCheck() {
        try {
            // Simulate response time or other log data
            Thread.sleep(100);  // Simulate slow response for anomaly detection
        } catch (InterruptedException e) {
            logger.error("Error during health check", e);
        }
        logger.info("Health check performed successfully.");
        return "Service is up!";
    }
}
