package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
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
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testSaveContact() {
        Contact contact1 = new Contact();
        contact1.setEmailAddress("test@123.com");
        contact1.setPhoneNumber("111-111-1111");

        assertNull(contact1.getId());
        contactRepository.save(contact1);
        assertNotNull(contact1.getId());

        Contact fetchedContact = contactRepository.findOne(contact1.getId());
        assertNotNull(fetchedContact);
        assertEquals(contact1.getId(), fetchedContact.getId());

        fetchedContact.setPhoneNumber("222-222-2222");
        contactRepository.save(fetchedContact);

        Contact fetchUpdatedContact = contactRepository.findOne(fetchedContact.getId());
        assertEquals("222-222-2222", fetchUpdatedContact.getPhoneNumber());



    }






}
