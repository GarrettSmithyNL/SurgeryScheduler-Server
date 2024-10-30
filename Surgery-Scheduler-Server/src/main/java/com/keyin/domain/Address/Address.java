package com.keyin.domain.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.util.Objects;

@Entity
public class Address {
  @Id
  @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1, initialValue = 1)
  @GeneratedValue(generator = "address_sequence")
  private long id;

  private int houseNumber;
  private String street;
  private String city;
  private String postalCode;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(int houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }
}
