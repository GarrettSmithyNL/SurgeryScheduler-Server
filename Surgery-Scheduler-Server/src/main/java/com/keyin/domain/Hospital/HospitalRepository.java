package com.keyin.domain.Hospital;

import com.keyin.domain.types.SurgeryTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {
  List<Hospital> findAllByAddress_City(String city);
  List<Hospital> findAllByListOfSurgeriesThatCanBeDone(SurgeryTypes surgeryTypes);
}
