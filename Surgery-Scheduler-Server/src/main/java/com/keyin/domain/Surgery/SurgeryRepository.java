package com.keyin.domain.Surgery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends CrudRepository<Surgery, Long> {
}
