package com.keyin.domain.Hospital;

import com.keyin.domain.Address.Address;
import com.keyin.domain.types.SurgeryTypes;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hospital {
  @Id
  @SequenceGenerator(name = "hospital_sequence", sequenceName = "hospital_sequence", allocationSize = 1, initialValue=1)
  @GeneratedValue(generator = "hospital_sequence")
  private long id;

  @OneToOne
  private Address addressID;

  private String name;

  @ElementCollection
  private List<SurgeryTypes> listOfSurgeriesThatCanBeDone;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Address getAddressID() {
    return addressID;
  }

  public void setAddressID(Address addressID) {
    this.addressID = addressID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SurgeryTypes> getListOfSurgeriesThatCanBeDone() {
    return listOfSurgeriesThatCanBeDone;
  }

  public void setListOfSurgeriesThatCanBeDone(List<SurgeryTypes> listOfSurgeriesThatCanBeDone) {
    this.listOfSurgeriesThatCanBeDone = listOfSurgeriesThatCanBeDone;
  }
}
