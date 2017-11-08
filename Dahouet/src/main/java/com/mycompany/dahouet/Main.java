/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dahouet;
import com.mycompany.dahouet.utils.VerifyEmail;
import com.mycompany.gui.forms.VoilierCreation;
import javax.swing.JFrame;
/**
 *
 * @author devrok
 */
public class Main {
    public static void main(String[] args){
        
        //email test
        
        System.out.println(VerifyEmail.isEmail("test@test.fr"));
   
        
         JFrame frame = new VoilierCreation();
         frame.pack();
         frame.setVisible(true);
    }
    

    
}
