package com.example.supervisor.controller;

import com.example.supervisor.model.Supervisor;
import com.example.supervisor.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/submit")
    public ResponseEntity<String> submitNotification(@RequestBody Supervisor supervisor) {
        return supervisorService.submitNotification(supervisor);
    }
}
