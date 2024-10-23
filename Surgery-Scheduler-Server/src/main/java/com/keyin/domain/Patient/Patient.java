package com.keyin.domain.Patient;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.keyin.domain.Address.Address;
import jakarta.persistence.*;

@Entity
public class Patient {
  @Id
  @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1, initialValue = 1)
  @GeneratedValue(generator = "patient_sequence")
  private long id;

  private String mcpNumber;
  private String name;

  @OneToOne
  private Address address;

  public String getMcpNumber() {
    return mcpNumber;
  }

  public void setMcpNumber(String mcpNumber) {
    this.mcpNumber = mcpNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
