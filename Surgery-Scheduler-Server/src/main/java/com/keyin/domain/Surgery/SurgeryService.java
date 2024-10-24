package com.keyin.domain.Surgery;

import com.keyin.domain.Hospital.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {
  @Autowired
  private SurgeryRepository surgeryRepository;

  public Surgery createSurgery(Surgery surgery) {
    return surgeryRepository.save(surgery);
  }

  public List<Surgery> findAllSurgeries() {
    return (List<Surgery>) surgeryRepository.findAll();
  }

  public Surgery findSurgeryById(Long id) {
    Optional<Surgery> optionalSurgery = surgeryRepository.findById(id);
    return optionalSurgery.orElse(null);
  }


  public List<Surgery> findSurgeriesByHospital(Hospital hospital) {
    return surgeryRepository.findSurgeriesByHospital(hospital);
  }
}
