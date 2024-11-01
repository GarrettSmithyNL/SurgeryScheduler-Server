package com.keyin.domain.Doctor;

import com.keyin.domain.Hospital.Hospital;
import com.keyin.domain.types.SurgeryTypes;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
  @Id
  @SequenceGenerator(name = "doctor_sequence", sequenceName = "doctor_sequence", allocationSize = 1, initialValue=1)
  @GeneratedValue(generator = "doctor_sequence")
  private long id;

  private String name;

  @ElementCollection
  private List<SurgeryTypes> listOfPossibleSurgeries;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SurgeryTypes> getListOfPossibleSurgeries() {
    return listOfPossibleSurgeries;
  }

  public void setListOfPossibleSurgeries(List<SurgeryTypes> listOfPossibleSurgeries) {
    this.listOfPossibleSurgeries = listOfPossibleSurgeries;
  }
}
