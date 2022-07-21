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

import com.hashan.silva.contact.util.EndpointNamingUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getContactsCountTest() throws MalformedURLException {
        ResponseEntity<Long> response = restTemplate.getForEntity(new URL("http://localhost:" + port + EndpointNamingUtil.CONTACT + "/" + EndpointNamingUtil.COUNT).toString(), Long.class);
        assertEquals(478, response.getBody());
    }

    @Test
    public void getContactsTest() throws MalformedURLException {
        ResponseEntity<List> response = restTemplate.getForEntity(new URL("http://localhost:" + port + EndpointNamingUtil.CONTACT).toString(), List.class);
        assertTrue(!response.getBody().isEmpty());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
