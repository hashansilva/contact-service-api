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
import com.hashan.silva.contact.util.EndpointNamingUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Contact Service", description = "API for contact service")
@RequestMapping(EndpointNamingUtil.CONTACT)
public interface IContactController {

    /**
     * Get the contacts
     *
     * @param name
     * @param limit
     * @param page
     * @return
     */
    @Operation(summary = "Get the contacts", description = "Search the contacts", responses = {
            @ApiResponse(responseCode = "200", description = "List of contacts")
    })
    @GetMapping
    default public List<Contact> getContacts(
            @Parameter(description = "Contact Name") @RequestParam(required = false) String name,
            @Parameter(description = "Limit") @RequestParam(required = false, defaultValue = "10") Integer limit,
            @Parameter(description = "Page") @RequestParam(required = false, defaultValue = "0") Integer page) {
        throw new NotImplementedException("Feature is not implemented yet");
    }

    /**
     * Get the count of the contacts
     *
     * @return
     */
    @Operation(summary = "Get Contacts Count", description = "Count of the contacts", responses = {
            @ApiResponse(responseCode = "200", description = "number of contacts")
    })
    @GetMapping(value = EndpointNamingUtil.COUNT)
    default public Long getContactsCount() {
        throw new NotImplementedException("Feature is not implemented yet");
    }
}
