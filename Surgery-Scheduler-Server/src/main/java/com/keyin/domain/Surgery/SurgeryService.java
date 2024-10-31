package com.keyin.domain.Surgery;

import com.keyin.domain.Doctor.Doctor;
import com.keyin.domain.Doctor.DoctorRepository;
import com.keyin.domain.Hospital.Hospital;
import com.keyin.domain.Hospital.HospitalRepository;
import com.keyin.domain.Patient.Patient;
import com.keyin.domain.Patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {
  @Autowired
  private SurgeryRepository surgeryRepository;

  @Autowired
    private HospitalRepository hospitalRepository;

  @Autowired
    private DoctorRepository doctorRepository;

  @Autowired
  private PatientRepository patientRepository;

  public Surgery createSurgery(Surgery surgery) {

    Optional<Patient> patient = patientRepository.findById(surgery.getPatient().getId());
    patient.ifPresent(surgery::setPatient);

    Optional<Doctor> doctor = doctorRepository.findById(surgery.getDoctorDoingSurgery().getId());
    doctor.ifPresent(surgery::setDoctorDoingSurgery);

    Optional<Hospital> hospital = hospitalRepository.findById(surgery.getHospital().getId());
    hospital.ifPresent(surgery::setHospital);

    return surgeryRepository.save(surgery);
  }

  public List<Surgery> findAllSurgeries() {
    return (List<Surgery>) surgeryRepository.findAll();
  }

  public Surgery findSurgeryById(Long id) {
    Optional<Surgery> optionalSurgery = surgeryRepository.findById(id);
    return optionalSurgery.orElse(null);
  }


  public List<Surgery> findSurgeriesByHospital(Long hospitalId) {
    Optional<Hospital> hospital = hospitalRepository.findById(hospitalId);
    return hospital.map(surgeryRepository::findSurgeriesByHospital).orElse(null);
  }

  public List<Surgery> findSurgeriesByDoctorId(Long doctorId) {
    return surgeryRepository.findByDoctorDoingSurgeryId(doctorId);
  }

  public List<Surgery> findUpcomingSurgeriesForPatient(Long patientId) {
    return surgeryRepository.findUpcomingSurgeriesByPatientId(patientId);
  }

  public List<Surgery> findSurgeriesByDate(LocalDate date) {
    return surgeryRepository.findSurgeriesByDate(date);
  }
}
