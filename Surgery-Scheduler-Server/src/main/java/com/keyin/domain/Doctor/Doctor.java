package com.keyin.domain.Doctor;

import com.keyin.domain.Hospital.Hospital;
import com.keyin.domain.types.SurgeryTypes;
import jakarta.persistence.*;

import java.util.List;
import java.time.LocalDate;

@Entity
public class Doctor {
  @Id
  @SequenceGenerator(name = "doctor_sequence", sequenceName = "doctor_sequence", allocationSize = 1, initialValue=1)
  @GeneratedValue(generator = "doctor_sequence")
  private long id;

  private String name;

  @ElementCollection
  private List<SurgeryTypes> listOfPossibleSurgeries;

  @OneToMany
  private List<Hospital> listOfWorkableHospitals;

  @ElementCollection
  private List<LocalDate> availableDates; // New field for tracking available dates

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

  public List<Hospital> getListOfWorkableHospitals() {
    return listOfWorkableHospitals;
  }

  public void setListOfWorkableHospitals(List<Hospital> listOfWorkableHospitals) {
    this.listOfWorkableHospitals = listOfWorkableHospitals;
  }
  public List<LocalDate> getAvailableDates() { return availableDates; }
  public void setAvailableDates(List<LocalDate> availableDates) { this.availableDates = availableDates; }
}
