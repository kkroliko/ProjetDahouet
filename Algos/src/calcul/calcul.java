/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;


import java.util.Arrays;
import java.util.List;
import models.Personne;

/**
 *
 * @author devrok
 */
public class calcul {
    public static double moyenneAge(List<Personne> p){
        double ageSomme =0;
        for (Personne per:p) {
            ageSomme += Personne.calculAge(per.getAnneeNaissance());
            
        }
        double moyenne=ageSomme/p.size();
        
        return moyenne;
    }
    
    public static int medianAge(List<Personne>p){
        //Creer une list de la taille du nombre de personne dans l'array liste
      int[] ages = new int[p.size()];

 
       //On declare la variable I pour parcourir la liste
       int i=0;
       // go through the Array list/calculate the age of each person and add it in the list Ages
      for(Personne per:p){
         ages[i]=(Personne.calculAge(per.getAnneeNaissance()));
         i++;
      }
      //trie de la liste
      Arrays.sort(ages);
        int milieu = ages.length/2;
        int median = 0;
        if(ages.length%2==1)
            median = ages[milieu];
        else
            median =(ages[milieu-1]+ages[milieu])/2;
        
        return median;
}
}
