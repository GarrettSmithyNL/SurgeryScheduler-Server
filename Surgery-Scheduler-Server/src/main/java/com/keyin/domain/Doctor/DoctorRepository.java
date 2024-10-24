package com.keyin.domain.Doctor;

import com.keyin.domain.types.SurgeryTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
  List<Doctor> findAllByListOfPossibleSurgeriesIsContainingIgnoreCase(SurgeryTypes surgeryType);
}
