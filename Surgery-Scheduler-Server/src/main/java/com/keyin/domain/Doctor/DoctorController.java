package com.keyin.domain.Doctor;

import com.keyin.domain.types.SurgeryTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorServices doctorServices;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor newDoctor) {
        return doctorServices.createDoctor(newDoctor);
    }

    @GetMapping
    public List<Doctor> findAllDoctors() {
        return doctorServices.findAllDoctors();
    }

    @GetMapping("/possible-surgery/{surgeryType}")
    public List<Doctor> findDoctorsBySurgeryType(@PathVariable SurgeryTypes surgeryType) {
        return doctorServices.findAllByListOfPossibleSurgeriesIsContainingIgnoreCase(surgeryType);
    }

    // Endpoint to get available doctors by date
    @GetMapping("/available")
    public List<Doctor> getAvailableDoctors(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date); // Parse the date from query parameter
        return doctorServices.findAvailableDoctorsByDate(localDate);
    }
}
