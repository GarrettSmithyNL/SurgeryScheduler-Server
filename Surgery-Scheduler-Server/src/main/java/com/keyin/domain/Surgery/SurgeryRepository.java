package com.keyin.domain.Surgery;

import com.keyin.domain.Hospital.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SurgeryRepository extends CrudRepository<Surgery, Long> {
  List<Surgery> findSurgeriesByHospital(Hospital hospital);

    List<Surgery> findUpcomingSurgeriesByPatientId(long patientId);

  List<Surgery> findAllByTimeStartBetween(LocalDateTime startTime, LocalDateTime endTime);

  List<Surgery> findAllByDoctorDoingSurgery_Id(long doctorId);

}
