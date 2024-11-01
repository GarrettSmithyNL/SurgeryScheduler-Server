package com.keyin.domain.Surgery;

import com.keyin.domain.Doctor.Doctor;
import com.keyin.domain.Doctor.DoctorRepository;
import com.keyin.domain.Doctor.DoctorServices;
import com.keyin.domain.Hospital.Hospital;
import com.keyin.domain.Hospital.HospitalRepository;
import com.keyin.domain.Hospital.HospitalService;
import com.keyin.domain.Patient.Patient;
import com.keyin.domain.Patient.PatientRepository;
import com.keyin.domain.Patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {
  @Autowired
  private SurgeryRepository surgeryRepository;

  @Autowired
    private HospitalService hospitalService;

  @Autowired
    private DoctorServices doctorServices;

  @Autowired
  private PatientService patientService;

  public Surgery createSurgery(Surgery newSurgery) {
    newSurgery.setPatient(patientService.createPatient(newSurgery.getPatient()));
    newSurgery.setDoctorDoingSurgery(doctorServices.createDoctor(newSurgery.getDoctorDoingSurgery()));
    newSurgery.setHospital(hospitalService.createHospital(newSurgery.getHospital()));
    return surgeryRepository.save(newSurgery);
  }

  public List<Surgery> createSurgeries(List<Surgery> surgeries) {
    for (Surgery surgery : surgeries) {
      surgery = createSurgery(surgery);
    }
    return surgeries;
  }

  public List<Surgery> findAllSurgeries() {
    return (List<Surgery>) surgeryRepository.findAll();
  }

  public Surgery findSurgeryById(Long id) {
    Optional<Surgery> optionalSurgery = surgeryRepository.findById(id);
    return optionalSurgery.orElse(null);
  }


  public List<Surgery> findSurgeriesByHospital(Long hospitalId) {
    List<Surgery> results = (List<Surgery>) surgeryRepository.findAll();
    results.removeIf(surgery -> surgery.getHospital().getId() != hospitalId);
    return results;
  }
}
