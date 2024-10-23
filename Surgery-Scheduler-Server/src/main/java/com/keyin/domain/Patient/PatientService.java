package com.keyin.domain.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
  @Autowired
  private PatientRepository patientRepository;

  public Patient createPatient (Patient patient) {
    return patientRepository.save(patient);
  }

  public Patient findByPatientId (long id) {
    Optional<Patient> patientOptional = patientRepository.findById(id);
    return patientOptional.orElse(null);
  }

  public Patient findByMcpNumber (String mcpNumber) {
    return patientRepository.findByMcpNumber(mcpNumber);
  }

  public List<Patient> findAllPatients () {
    return (List<Patient>) patientRepository.findAll();
  }


}
