package com.keyin.domain.Address;

import com.keyin.domain.Hospital.Hospital;
import com.keyin.domain.Surgery.Surgery;
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
    for (Address address : addresses) {
      Address addressInDB = findAddressByStreetAndHouseNumber(address);
      if (addressInDB != null && addressInDB.getCity().equals(address.getCity())) {
        address = addressInDB;
      }
      addressRepository.save(address);
    }
    return addresses;
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
  // New method to update an existing address
  public Address updateAddress(long id, Address updatedAddress) {
    Optional<Address> optionalAddress = addressRepository.findById(id);
    if (optionalAddress.isPresent()) {
      Address address = optionalAddress.get();
      address.setStreet(updatedAddress.getStreet());
      address.setHouseNumber(updatedAddress.getHouseNumber());
      address.setCity(updatedAddress.getCity());
      address.setPostalCode(updatedAddress.getPostalCode());
      return addressRepository.save(address);
    } else {
      return null;
    }
  }

  // New method to delete an address by ID
  public void deleteAddress(long id) {
    addressRepository.deleteById(id);
  }


  public Address updateAddress(Address updatedAddress) {
    Optional<Address> existingAddress = addressRepository.findById(updatedAddress.getId());
    if (existingAddress.isPresent()) {
      // Save the updated address to persist changes in the database
      return addressRepository.save(updatedAddress);
    } else {
      throw new RuntimeException("Address not found with id " + updatedAddress.getId());
    }
  }

}
