package com.keyin.domain.Surgery;

import com.keyin.domain.Hospital.Hospital;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SurgeryRepository extends CrudRepository<Surgery, Long> {
  List<Surgery> findSurgeriesByHospital(Hospital hospital);
  List<Surgery> findByDoctorDoingSurgeryId(Long doctorId);
  List<Surgery> findUpcomingSurgeriesByPatientId(Long patientId);

  @Query("SELECT s FROM Surgery s WHERE DATE(s.timeStart) = :date")
  List<Surgery> findSurgeriesByDate(LocalDate date);

}
