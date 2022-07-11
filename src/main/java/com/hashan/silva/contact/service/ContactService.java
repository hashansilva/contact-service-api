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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /**
     * Get Contacts
     *
     * @param name
     * @param limit
     * @param page
     * @return
     */
    public List<Contact> getContacts(String name, int limit, int page) {
        Pageable pageable = PageRequest.of(page, limit);
        return this.contactRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    /**
     * Get contacts count
     *
     * @return
     */
    public Long getContactsCount() {
        return this.contactRepository.count();
    }
}
