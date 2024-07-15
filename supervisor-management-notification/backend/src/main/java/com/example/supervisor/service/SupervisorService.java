package com.example.supervisor.service;

import com.example.supervisor.model.Supervisor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupervisorService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String SUPERVISOR_API_URL = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";

    public List<String> getAllSupervisors() {
        Supervisor[] supervisors = restTemplate.getForObject(SUPERVISOR_API_URL, Supervisor[].class);
        return Arrays.stream(supervisors)
                .map(s -> String.format("%s - %s, %s", s.getJurisdiction(), s.getLastName(), s.getFirstName()))
                .filter(s -> !Character.isDigit(s.charAt(0)))
                .sorted()
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> submitNotification(Supervisor supervisor) {
        if (supervisor.getFirstName().isEmpty() || supervisor.getLastName().isEmpty() || supervisor.getSupervisor().isEmpty()) {
            return ResponseEntity.badRequest().body("First name, last name, and supervisor fields are required.");
        }

        if (!supervisor.getFirstName().matches("[a-zA-Z]+") || !supervisor.getLastName().matches("[a-zA-Z]+")) {
            return ResponseEntity.badRequest().body("Name fields must only contain letters.");
        }

        if (supervisor.getEmail() != null && !supervisor.getEmail().isEmpty() && !supervisor.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return ResponseEntity.badRequest().body("Invalid email format.");
        }

        if (supervisor.getPhoneNumber() != null && !supervisor.getPhoneNumber().isEmpty() && !supervisor.getPhoneNumber().matches("^[0-9]{10}$")) {
            return ResponseEntity.badRequest().body("Invalid phone number format.");
        }

        System.out.println(supervisor);
        return ResponseEntity.ok("Notification submitted successfully.");
    }
}
