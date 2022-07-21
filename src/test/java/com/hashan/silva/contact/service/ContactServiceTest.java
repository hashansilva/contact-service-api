/*
 * Copyright (c) 2022. Hashan Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

package com.hashan.silva.contact.service;

import com.hashan.silva.contact.domain.Contact;
import com.hashan.silva.contact.repository.ContactRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class ContactServiceTest {

    private static List<Contact> contactsList;
    @Mock
    private ContactRepository contactRepository;
    @InjectMocks
    private ContactService contactService = new ContactService();

    @BeforeAll
    public static void setupContacts() {
        ContactServiceTest.contactsList = new ArrayList<>();
        Contact contact1 = new Contact();
        contact1.setName("Test1");
        contact1.setUrl("test_url1");
        Contact contact2 = new Contact();
        contact2.setName("Test2");
        contact2.setUrl("test_url2");
        ContactServiceTest.contactsList.add(contact1);
        ContactServiceTest.contactsList.add(contact2);

    }

    @Test
    public void getContactsCountTest() {
        Mockito.when(contactRepository.count()).thenReturn(Long.valueOf(350));
        assertEquals(350, contactService.getContactsCount());
    }

    @Test
    public void getContactsTest_withName() {
        List<Contact> contacts = getContacts("Test1");
        Mockito.when(contactRepository.findByNameContainingIgnoreCase(anyString(), any(Pageable.class))).thenReturn(contacts);
        assertEquals(contacts.size(), contactService.getContacts("Test1", 10, 0).size());
    }

    @Test
    public void getContactsTest_withoutName() {
        List<Contact> contacts = getContacts(null);
        Page<Contact> contactPage = new PageImpl<>(contacts);
        Mockito.when(contactRepository.findAll(any(Pageable.class))).thenReturn(contactPage);
        assertEquals(contacts.size(), contactService.getContacts(null, 10, 0).size());
    }

    private List<Contact> getContacts(String test) {
        if (test != null && test.length() > 0) {
            return ContactServiceTest.contactsList.stream().filter(contact -> test.equals(contact.getName())).collect(Collectors.toList());
        }
        return ContactServiceTest.contactsList;
    }

}
