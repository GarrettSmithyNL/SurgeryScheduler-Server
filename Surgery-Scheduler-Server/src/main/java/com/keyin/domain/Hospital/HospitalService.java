package com.keyin.domain.Hospital;

import com.keyin.domain.Address.Address;
import com.keyin.domain.Address.AddressRepository;
import com.keyin.domain.Address.AddressService;
import com.keyin.domain.types.SurgeryTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

  @Autowired
  private HospitalRepository hospitalRepository;

  @Autowired
  private AddressService addressService;

  public Hospital createHospital(Hospital newHospital) {
    newHospital.setAddress(addressService.createAddress(newHospital.getAddress()));
    return hospitalRepository.save(newHospital);
  }

  public List<SurgeryTypes> initializeSurgeryTypes() {
    List<SurgeryTypes> surgeryTypes = Arrays.asList(SurgeryTypes.values());
    return surgeryTypes;
  }


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
