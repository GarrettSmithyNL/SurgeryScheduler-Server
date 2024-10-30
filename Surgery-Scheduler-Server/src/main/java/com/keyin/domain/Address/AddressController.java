package com.keyin.domain.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address createAddress(@RequestBody Address newAddress) {
        return addressService.createAddress(newAddress);
    }

    @PostMapping("/batch")
    public List<Address> createAddresses(@RequestBody List<Address> addresses) {
        return addressService.createAddresses(addresses);
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.findAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable long id) {
        return addressService.findAddressById(id);
    }

    @GetMapping("/search")
    public Address getAddressByStreetAndHouseNumber(@RequestParam String street, @RequestParam int houseNumber) {
        Address address = new Address();
        address.setStreet(street);
        address.setHouseNumber(houseNumber);
        return addressService.findAddressByStreetAndHouseNumber(address);
    }
    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable long id, @RequestBody Address updatedAddress) {
        updatedAddress.setId(id);
        return addressService.updateAddress(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable long id) {
        addressService.deleteAddress(id);
    }


}
