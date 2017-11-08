/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos;

import calcul.calcul;
import exception.exception;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Commissaire;
import models.Licencie;
import models.Personne;
import models.Proprietaire;

/**
 *
 * @author devrok
 */
public class Algos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // instancer le jeu d'essai
        Proprietaire proprietaire1 = new Proprietaire("Stout","Mary","m.stout@gmail.com",1984);
        Proprietaire proprietaire2= new Proprietaire("Sellers","Peter","p.sellers@gmail.com",1977);
        Licencie licencie1 = new Licencie(15,3,2017,"max","pierre","ok.sele@gmail.com",1987);
        Licencie licencie2 = new Licencie(13,3,2017,"max","pierre","ok.sele@gmail.com",1987);
        Licencie licencie3 = new Licencie(14,3,2017,"max","pierre","ok.sele@gmail.com",1987);
        Commissaire commissaire = new Commissaire("commité super", "konrad", "krolikowski", "k.kroliko@gmail.com",1994);
        
        // mettre le jeu d'essai dans une collection
        
        List<Personne>personnes = new ArrayList();
        personnes.add(licencie3);
        personnes.add(licencie2);
        personnes.add(licencie1);
        personnes.add(commissaire);
        personnes.add(proprietaire2);
        personnes.add(proprietaire1);
        
        //affichage dans la console
        for(Personne p:personnes){
            System.out.println(p);
        }
        double median =calcul.medianAge(personnes);
        double moyenne = calcul.moyenneAge(personnes);
        System.out.println("median = "+median);
        System.out.println("moyenne = "+moyenne);
        
       //Test
        int cal1 = 2017;
       
      
        //TEst
        try {
            licencie1.calculPoints(5, cal1);
        } catch (exception ex) {
            Logger.getLogger(Algos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        System.out.println(licencie1);
       
        
}
    }
  

