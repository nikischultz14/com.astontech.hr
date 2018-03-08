package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSaveAddress() {

        Address address1 = new Address();
        address1.setStreetAddress("111 Test Ave");
        address1.setCity("Testington");
        address1.setState("MN");
        address1.setZipCode(11111);

        assertNull(address1.getId());
        addressRepository.save(address1);
        assertNotNull(address1.getId());

        Address fetchedAddress = addressRepository.findOne(address1.getId());
        assertNotNull(fetchedAddress);
        assertEquals(address1.getId(), fetchedAddress.getId());

        fetchedAddress.setState("WI");
        addressRepository.save(fetchedAddress);

        Address fetchUpdatedAddress = addressRepository.findOne(fetchedAddress.getId());
        assertEquals("WI", fetchUpdatedAddress.getState());
    }
}
