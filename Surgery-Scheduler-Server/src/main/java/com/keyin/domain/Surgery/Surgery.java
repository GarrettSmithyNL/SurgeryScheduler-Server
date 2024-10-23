package com.keyin.domain.Surgery;

import com.keyin.domain.Hospital.Hospital;
import com.keyin.domain.Patient.Patient;
import com.keyin.domain.types.SurgeryTypes;
import jakarta.persistence.*;
import com.keyin.domain.Doctor.Doctor;

import java.util.Date;

@Entity
public class Surgery {
  @Id
  @SequenceGenerator(name = "surgery_sequence", sequenceName = "surgery_sequence", allocationSize = 1, initialValue = 1)
  @GeneratedValue(generator = "surgery_sequence")
  private long id;

  @OneToOne
  private Doctor doctorDoingSurgery;

  @ManyToOne
  private Patient patient;

  @OneToOne
  private Hospital hospital;

  private Date timeStart;

  private Date timeEnd;

  private long durationOfSurgery;

  private SurgeryTypes typeOfSurgery;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Doctor getDoctorDoingSurgery() {
    return doctorDoingSurgery;
  }

  public void setDoctorDoingSurgery(Doctor doctorDoingSurgery) {
    this.doctorDoingSurgery = doctorDoingSurgery;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Hospital getHospital() {
    return hospital;
  }

  public void setHospital(Hospital hospital) {
    this.hospital = hospital;
  }

  public Date getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(Date timeStart) {
    this.timeStart = timeStart;
  }

  public Date getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(Date timeEnd) {
    this.timeEnd = timeEnd;
  }

  public long getDurationOfSurgery() {
    return durationOfSurgery;
  }

  public void setDurationOfSurgery(long durationOfSurgery) {
    this.durationOfSurgery = durationOfSurgery;
  }

  public SurgeryTypes getTypeOfSurgery() {
    return typeOfSurgery;
  }

  public void setTypeOfSurgery(SurgeryTypes typeOfSurgery) {
    this.typeOfSurgery = typeOfSurgery;
  }
}
