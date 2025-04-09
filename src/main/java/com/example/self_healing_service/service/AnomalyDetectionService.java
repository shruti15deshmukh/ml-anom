//package com.example.self_healing_service.service;
//
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class AnomalyDetectionService {
//
//    // Simulate an anomaly detection logic (simple threshold)
//    public boolean detectAnomaly(double responseTime) {
//        // Example threshold for slow responses (in ms)
//        double threshold = 150.0;
//        return responseTime > threshold;  // If response time exceeds threshold, it's an anomaly
//    }
//}
package com.example.self_healing_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnomalyDetectionService {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean detectAnomalyFromLog(String logMessage) {
        // Prepare request body with simulated metrics (replace with actual parsing if needed)
        Map<String, Object> payload = new HashMap<>();
        payload.put("response_time", 500.0);
        payload.put("error_count", 15);
        payload.put("cpu_usage", 95.0);
        payload.put("memory_usage", 99.0);
        payload.put("disk_io", 400.0);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload);
        ResponseEntity<Map> response = restTemplate.postForEntity("http://localhost:5006/predict", request, Map.class);

        if (response.getBody() != null && response.getBody().get("prediction") != null) {
            int prediction = (Integer) response.getBody().get("prediction");
            return prediction == 1;
        }

        return false; // default if response is null or prediction missing
    }


}

