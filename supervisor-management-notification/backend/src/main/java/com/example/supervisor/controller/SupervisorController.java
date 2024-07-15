package com.example.supervisor.controller;

import com.example.supervisor.model.Supervisor;
import com.example.supervisor.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @GetMapping("/supervisors")
    public List<String> getSupervisors() {
        return supervisorService.getAllSupervisors();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/submit")
        public ResponseEntity<String> submitNotification(@RequestBody Supervisor request) {
            // Validate required fields
            if (request.getFirstName() == null || request.getLastName() == null || request.getSupervisor() == null) {
                return new ResponseEntity<>("First name, last name, and supervisor are required fields.", HttpStatus.BAD_REQUEST);
            }

            // Print the request to the console
            System.out.println(request.toString());

            return new ResponseEntity<>("Notification request submitted successfully", HttpStatus.OK);
        }
}
