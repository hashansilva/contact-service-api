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

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class IContactControllerTest {

    @Mock
    private IContactController contactController;

    @Test
    public void getContactsCount_throwException() {
        Mockito.when(contactController.getContactsCount()).thenThrow(new NotImplementedException("Feature not implemented yet"));
        NotImplementedException exception = Assertions.assertThrows(NotImplementedException.class, () -> {

            contactController.getContactsCount();
        }, "NotImplementedException was expected");
        Assertions.assertEquals("Feature not implemented yet", exception.getMessage());
    }

    @Test
    public void getContacts_throwException() {
        Mockito.when(contactController.getContacts(anyString(), anyInt(), anyInt())).thenThrow(new NotImplementedException("Feature not implemented yet"));
        NotImplementedException exception = Assertions.assertThrows(NotImplementedException.class, () -> {

            contactController.getContacts("",10,0);
        }, "NotImplementedException was expected");
        Assertions.assertEquals("Feature not implemented yet", exception.getMessage());
    }
}
