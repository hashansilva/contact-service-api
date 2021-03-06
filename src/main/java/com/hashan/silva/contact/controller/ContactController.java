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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController implements IContactController {

    @Autowired
    private ContactService contactService;

    /**
     * Search Contact Lists
     *
     * @param name
     * @param limit
     * @param page
     * @return
     */
    @Override
    public List<Contact> getContacts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "10") Integer limit,
            @RequestParam(required = false, defaultValue = "0") Integer page) {
        return this.contactService.getContacts(name, limit, page);
    }

    /**
     * Get contacts count
     *
     * @return
     */
    @Override
    public Long getContactsCount() {
        return this.contactService.getContactsCount();
    }
}
