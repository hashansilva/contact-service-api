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

package com.hashan.silva.contact.controller;

import com.hashan.silva.contact.domain.Contact;
import com.hashan.silva.contact.service.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class ContactControllerTest {

    @Mock
    ContactService contactService;

    @InjectMocks
    ContactController contactController;

    @Test
    public void getContactsCountTest() throws MalformedURLException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Mockito.when(contactService.getContactsCount()).thenReturn(Long.valueOf(350));

        Long responseEntity = contactController.getContactsCount();

        Assertions.assertEquals(350, responseEntity);

    }

    @Test
    public void getContactsTest() throws MalformedURLException {
        List<Contact> contacts = this.getContacts();
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Mockito.when(contactService.getContacts(anyString(), anyInt(), anyInt())).thenReturn(contacts);

        List<Contact> responseEntity = contactController.getContacts("",10,0);

        Assertions.assertEquals(contacts.size(), responseEntity.size());
        assertTrue(!responseEntity.isEmpty());
    }

    private List<Contact> getContacts() {
        List<Contact> contactsList = new ArrayList<>();
        Contact contact1 = new Contact();
        contact1.setName("Test1");
        contact1.setUrl("test_url1");
        Contact contact2 = new Contact();
        contact2.setName("Test2");
        contact2.setUrl("test_url2");
        contactsList.add(contact1);
        contactsList.add(contact2);
        return contactsList;
    }
}
