package com.keyin.domain.Surgery;

import com.keyin.domain.Patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/surgery")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

    @PostMapping
    public Surgery createSurgery(@RequestBody Surgery newSurgery) {
        return surgeryService.createSurgery(newSurgery);
    }

    @PostMapping ("/batch")
    public List<Surgery> createPatients(@RequestBody List<Surgery> surgeries) {
        return surgeryService.createSurgeries(surgeries);
    }

    @GetMapping
    public List<Surgery> getAllSurgeries() {
        return surgeryService.findAllSurgeries();
    }

    @GetMapping("/{id}")
    public Surgery getSurgeryById(@PathVariable Long id) {
        return surgeryService.findSurgeryById(id);
    }

    @GetMapping("/hospital-surgeries/{hospitalId}")
    public List<Surgery> getSurgeriesByHospital(@PathVariable Long hospitalId) {
        return surgeryService.findSurgeriesByHospital(hospitalId);
    }

    @GetMapping("/surgeries/doctor/{doctorId}")
    public List<Surgery> getSurgeriesByDoctor(@PathVariable Long doctorId) {
        return surgeryService.findSurgeriesByDoctorId(doctorId);
    }

    @GetMapping("/surgeries/patient/{patientId}/upcoming")
    public List<Surgery> getUpcomingSurgeriesForPatient(@PathVariable Long patientId) {
        return surgeryService.findUpcomingSurgeriesForPatient(patientId);
    }

    @GetMapping("/search/date/{date}")
    public List<Surgery> getSurgeriesByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return surgeryService.findSurgeriesByDate(localDate);
    }
}
