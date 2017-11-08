/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dahouet.utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author devrok
 */


    public class VerifyEmailTest {
     
     VerifyEmail emailCheck = new VerifyEmail();
     
     public VerifyEmailTest(){}
     
     /*

        Test of emailIsCorrect method, of class Iscorrect.
        */
        @Test
        public void testEmailCorrect() {
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