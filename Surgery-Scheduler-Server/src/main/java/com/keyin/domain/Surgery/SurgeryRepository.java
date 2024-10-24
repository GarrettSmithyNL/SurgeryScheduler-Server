package com.keyin.domain.Surgery;

import com.keyin.domain.Hospital.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurgeryRepository extends CrudRepository<Surgery, Long> {
  List<Surgery> findSurgeriesByHospital(Hospital hospital);
}
