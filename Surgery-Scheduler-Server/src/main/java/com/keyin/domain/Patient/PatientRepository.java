package com.keyin.domain.Patient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
  public Patient findByMcpNumber(String mcpNumber);
}
