package com.astontech.hr.services;

import com.astontech.hr.domain.Address;

public interface AddressService {

    Iterable<Address> listAllAddresses();

    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    Iterable<Address> saveAddressIterable(Iterable<Address> addressIterable);

    void deleteAddress(Integer id);
}
