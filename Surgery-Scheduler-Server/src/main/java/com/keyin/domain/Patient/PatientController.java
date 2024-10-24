package com.keyin.domain.Patient;


import com.keyin.domain.Address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient createPatient(@RequestBody Patient newPatient) {
        return patientService.createPatient(newPatient);
    }

    @PostMapping("/batch")
    public List<Patient> createPatients(@RequestBody List<Patient> patients) {
        return patientService.createPatients(patients);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.findAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable long id) {
        return patientService.findByPatientId(id);
    }

    @GetMapping("/search")
    public Patient getPatientByMcpNumber(@RequestParam String mcpNumber) {
        return patientService.findByMcpNumber(mcpNumber);
    }
}
