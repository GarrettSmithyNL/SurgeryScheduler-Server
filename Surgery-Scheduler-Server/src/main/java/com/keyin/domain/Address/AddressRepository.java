package com.keyin.domain.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
  public Address findAddressByStreetAndHouseNumber(String street, int houseNumber);
}
