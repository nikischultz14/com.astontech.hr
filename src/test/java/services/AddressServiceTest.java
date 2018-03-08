package services;


import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.services.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void addressServiceSaveTest() {

        Address address2 = new Address();
        address2.setState("MN");
        address2.setZipCode(11111);
        address2.setCity("Saint Paul");
        address2.setStreetAddress("222 Test Ave");

        assertNull(address2.getId());
        addressService.saveAddress(address2);
        assertNotNull(address2.getId());

        Address fetchedAddress = addressService.getAddressById(address2.getId());
        assertNotNull(fetchedAddress);
        assertEquals(address2.getId(), fetchedAddress.getId());

        fetchedAddress.setCity("Minneapolis");
        addressService.saveAddress(fetchedAddress);

        Address updateFetchedAddress = addressService.getAddressById(fetchedAddress.getId());
        assertEquals("Minneapolis", updateFetchedAddress.getCity());

    }






}
