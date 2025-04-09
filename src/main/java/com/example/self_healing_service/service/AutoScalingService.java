package com.example.self_healing_service.service;

import org.springframework.stereotype.Service;

@Service
public class AutoScalingService {

    public void performSelfHealingAction() {
        // Simulate healing action
        System.out.println("Self-healing triggered: restarting service or scaling up...");
    }
}
