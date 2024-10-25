package com.keyin.domain.Hospital;

import com.keyin.domain.types.SurgeryTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital newHospital) {
        return hospitalService.createHospital(newHospital);
    }

    @PostMapping("/initialize-surgery-types")
    public List<SurgeryTypes> initializeSurgeryTypes() {
        return hospitalService.initializeSurgeryTypes();
    }

    @GetMapping
    public List<Hospital> findAllHospitals() {
        return hospitalService.findAllHospitals();
    }

    @GetMapping("/city/{city}")
    public List<Hospital> findHospitalsByCity(@PathVariable String city) {
        return hospitalService.findHospitalsByCity(city);
    }

    @GetMapping("/surgery/{surgeryTypes}")
    public List<Hospital> findHospitalBySurgeryThatCanBeDone(@PathVariable SurgeryTypes surgeryTypes) {
        return hospitalService.findHospitalBySurgeryThatCanBeDone(surgeryTypes);
    }

    @GetMapping("/{id}")
    public Hospital getHospitalById(@PathVariable long id) {
        return hospitalService.findById(id);
    }
}
