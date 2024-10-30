package com.keyin.domain.Doctor;

import com.keyin.domain.Hospital.Hospital;
import com.keyin.domain.Hospital.HospitalRepository;
import com.keyin.domain.types.SurgeryTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServices {

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private HospitalRepository hospitalRepository;

  public Doctor createDoctor(Doctor doctor) {
    List<Hospital> fullHospitals = doctor.getListOfWorkableHospitals().stream()
            .map(hospital -> hospitalRepository.findById(hospital.getId()).orElse(null))
            .collect(Collectors.toList());
    doctor.setListOfWorkableHospitals(fullHospitals);
    return doctorRepository.save(doctor);
  }

  public Doctor findDoctorById(long id) {
    Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
    return optionalDoctor.orElse(null);
  }

  public List<Doctor> findAllDoctors() {
    return (List<Doctor>) doctorRepository.findAll();
  }

  public List<Doctor> findAllByListOfPossibleSurgeriesIsContainingIgnoreCase(SurgeryTypes surgeryType) {
    return doctorRepository.findAllByListOfPossibleSurgeriesIsContainingIgnoreCase(surgeryType);
  }

  // New method to find available doctors by date
  public List<Doctor> findAvailableDoctorsByDate(LocalDate date) {
    // Implement the logic to filter doctors based on availability for the given date
    // Currently, returns all doctors for simplicity, but can customize with actual availability logic as needed
    return (List<Doctor>) doctorRepository.findAll(); // Modify with actual logic as needed
  }
}

//getdoctors by time need a surgery contorller to get this.

