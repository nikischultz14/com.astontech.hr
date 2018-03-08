package com.astontech.hr.services;

import com.astontech.hr.domain.Contact;

public interface ContactService {

    Iterable<Contact> listAllContacts();

    Contact getContactById(Integer id);

    Contact saveContact(Contact contact);

    Iterable<Contact> saveContactIterable(Iterable<Contact> contactIterable);

    void deleteContact(Integer id);




}
