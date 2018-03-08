package services;


import com.astontech.hr.Application;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.ContactService;
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
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void contactServiceSaveTest() {

        Contact contact2 = new Contact();
        contact2.setPhoneNumber("333-333-3333");
        contact2.setEmailAddress("test@google.com");

        assertNull(contact2.getId());
        contactService.saveContact(contact2);
        assertNotNull(contact2.getId());

        Contact fetchedContact = contactService.getContactById(contact2.getId());
        assertNotNull(fetchedContact);
        assertEquals(contact2.getId(), fetchedContact.getId());

        fetchedContact.setPhoneNumber("444-444-4444");
        contactService.saveContact(fetchedContact);

        Contact updateFetchedContact = contactService.getContactById(fetchedContact.getId());
        assertEquals("444-444-4444", updateFetchedContact.getPhoneNumber());

    }



}
