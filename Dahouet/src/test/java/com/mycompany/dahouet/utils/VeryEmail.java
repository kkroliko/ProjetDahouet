/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dahouet.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author devrok
 */
public class VeryEmail {

    public VeryEmail() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test_isEmail() {
        assertTrue(VerifyEmail.isEmail("ab@cd.ef"));
        assertTrue(VerifyEmail.isEmail("abcdef@ghij.klmn"));
        assertFalse(VerifyEmail.isEmail("ab@c.f.ef"));
        assertFalse(VerifyEmail.isEmail("a@ghij.klmn"));
        assertFalse(VerifyEmail.isEmail("ab@c.de"));
        assertFalse(VerifyEmail.isEmail("ab@cd.e"));
        assertFalse(VerifyEmail.isEmail("abcdefghij"));
        assertFalse(VerifyEmail.isEmail("abcdefghij.kl"));
        assertFalse(VerifyEmail.isEmail("ab@cdef"));
    }
}
