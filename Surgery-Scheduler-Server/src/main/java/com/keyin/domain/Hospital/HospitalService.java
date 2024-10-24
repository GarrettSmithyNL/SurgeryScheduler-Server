package com.keyin.domain.Hospital;

import com.keyin.domain.types.SurgeryTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
  @Autowired
  private HospitalRepository hospitalRepository;

  public Hospital findById (long id) {
    Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
    return optionalHospital.orElse(null);
  }

  public List<Hospital> findAllHospitals () {
    return (List<Hospital>) hospitalRepository.findAll();
  }

  public List<Hospital> findHospitalsByCity (String city) {
    return hospitalRepository.findAllByAddress_City(city);
  }

  public List<Hospital> findHospitalBySurgeryThatCanBeDone(SurgeryTypes surgeryTypes) {
    return hospitalRepository.findAllByListOfSurgeriesThatCanBeDone(surgeryTypes);
  }
}
