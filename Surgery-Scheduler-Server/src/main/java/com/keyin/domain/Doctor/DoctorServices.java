package com.keyin.domain.Doctor;

import com.keyin.domain.Hospital.Hospital;
import com.keyin.domain.Hospital.HospitalRepository;
import com.keyin.domain.types.SurgeryTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return doctorRepository.save(doctor);
    }

  public Doctor findDoctorById (long id) {
  Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
  return optionalDoctor.orElse(null);
  }

  public List<Doctor> findAllDoctors() {
    return (List<Doctor>) doctorRepository.findAll();
  }

  public List<Doctor> findAllByListOfPossibleSurgeriesIsContainingIgnoreCase (SurgeryTypes surgeryType) {
    return doctorRepository.findAllByListOfPossibleSurgeriesIsContainingIgnoreCase(surgeryType);
  }
}
