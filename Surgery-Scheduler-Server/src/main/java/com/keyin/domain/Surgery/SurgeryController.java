package com.keyin.domain.Surgery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/surgery")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

    @PostMapping
    public Surgery createSurgery(@RequestBody Surgery newSurgery) {
        return surgeryService.createSurgery(newSurgery);
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
    @GetMapping("/doctor/{doctorId}")
    public List<Surgery> getSurgeriesByDoctor(@PathVariable long doctorId) {
        return surgeryService.findSurgeriesByDoctor(doctorId);
    }
    @GetMapping("/search")
    public List<Surgery> searchSurgeriesByTime(@RequestParam LocalDateTime startTime, @RequestParam LocalDateTime endTime) {
        return surgeryService.findSurgeriesByTimeRange(startTime, endTime);
    }

}
