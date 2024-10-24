package com.keyin.domain.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
  @Autowired
  private AddressRepository addressRepository;

  public Address createAddress(Address address) {
    Address addressInDB = findAddressByStreetAndHouseNumber(address);
    if (addressInDB != null && addressInDB.getCity().equals(address.getCity())) {
      address = addressInDB;
    }
    return addressRepository.save(address);
  }

  public List<Address> createAddresses(List<Address> addresses) {
    return (List<Address>) addressRepository.saveAll(addresses);
  }

  public List<Address> findAllAddresses () {
    return (List<Address>) addressRepository.findAll();
  }

  public Address findAddressById (long id) {
    Optional<Address> addressOptional = addressRepository.findById(id);
    return addressOptional.orElse(null);
  }

  public Address findAddressByStreetAndHouseNumber (Address address) {
    return addressRepository.findAddressByStreetAndHouseNumber(address.getStreet(), address.getHouseNumber());
  }

}
