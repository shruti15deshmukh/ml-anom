package com.example.self_healing_service.controller;

import com.example.self_healing_service.service.AnomalyDetectionService;
import com.example.self_healing_service.service.AutoScalingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/system")
public class AutoScalingController
{

    private final AnomalyDetectionService anomalyService;
    private final AutoScalingService scalingService;

    public AutoScalingController(AnomalyDetectionService anomalyService, AutoScalingService scalingService) {
        this.anomalyService = anomalyService;
        this.scalingService = scalingService;
    }

    @PostMapping("/check-log")
    public String checkLog(@RequestBody Map<String, String> body) {
        String log = body.get("log");
        boolean isAnomaly = anomalyService.detectAnomalyFromLog(log);
        if (isAnomaly) {
            scalingService.performSelfHealingAction();
            return "Anomaly detected in logs. Self-healing triggered.";
        }
        return "Logs look normal. No action taken.";
    }
}
