/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Calendar;

/**
 *
 * @author devrok
 */
public class Personne {
    
    protected String nom;
    protected String prenom;
    protected String email;
    protected int anneeNaissance;

    
    public Personne(String nom, String prenom, String email, int anneeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", anneeNaissance=" + anneeNaissance + '}';
    }

    public static int calculAge(int annee){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age= year-annee;
        return age;
}
    
}
