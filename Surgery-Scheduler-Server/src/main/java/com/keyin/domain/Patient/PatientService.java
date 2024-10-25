package com.keyin.domain.Patient;

import com.keyin.domain.Address.Address;
import com.keyin.domain.Address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private AddressRepository addressRepository;

  public Patient createPatient (Patient newPatient) {
    Address address = addressRepository.findById(newPatient.getAddress().getId())
            .orElseThrow(() -> new RuntimeException("Address not found"));
    newPatient.setAddress(address);
    return patientRepository.save(newPatient);
  }

  public List<Patient> createPatients(List<Patient> patients) {
    for (Patient patient : patients) {
      Address address = addressRepository.findById(patient.getAddress().getId())
              .orElseThrow(() -> new RuntimeException("Address not found"));
      patient.setAddress(address);
    }
    return (List<Patient>) patientRepository.saveAll(patients);
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
