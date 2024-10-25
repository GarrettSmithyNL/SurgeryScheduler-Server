package com.keyin.domain.Patient;

import com.keyin.domain.Address.Address;
import com.keyin.domain.Address.AddressRepository;
import com.keyin.domain.Address.Address;
import com.keyin.domain.Address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private AddressService addressService;


  public Patient createPatient (Patient newPatient) {
    newPatient.setAddress(addressService.createAddress(newPatient.getAddress()));
    return patientRepository.save(newPatient);
  }

  public List<Patient> createPatients(List<Patient> patients) {
    for (Patient patient : patients) {
      patient.setAddress(addressService.createAddress(patient.getAddress()));
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
