/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dahouet.utils;

import java.util.regex.*;

/**
 *
 * @author devrok
 */
public class VerifyEmail {

    public static Boolean isEmail(String email) {

        return Pattern.matches("^[_a-z0-9-]{2,}+(\\.[_a-z0-9-]+)*@[a-z0-9-]{2,}+(\\.[a-z0-9-]{2,}+)+$", email);
    }

}
