/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import exception.exception;

/**
 *
 * @author devrok
 */
public class Licencie extends Personne  {
    
   private int numlicence;
   private double pointsFFV;
   private int anneeLicence;

    public Licencie(int numlicence, double pointsFFV, int anneeLicence, String nom, String prenom, String email, int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
        this.numlicence = numlicence;
        this.pointsFFV = pointsFFV;
        this.anneeLicence = anneeLicence;
    }

    public int getNumlicence() {
        return numlicence;
    }

    public void setNumlicence(int numlicence) {
        this.numlicence = numlicence;
    }

    public double getPointsFFV() {
        return pointsFFV;
    }

    public void setPointsFFV(double pointsFFV) {
        this.pointsFFV = pointsFFV;
    }

    public int getAnneeLicence() {
        return anneeLicence;
    }

    public void setAnneeLicence(int anneeLicence) {
        this.anneeLicence = anneeLicence;
    }

    @Override
    public String toString() {
        return "Licencie{" + "numlicence=" + numlicence + ", pointsFFV=" + pointsFFV + ", anneeLicence=" + anneeLicence + '}';
    }
    
    public void calculPoints(double point,int year) throws exception{
        if(year==anneeLicence){
            pointsFFV+=point;
        }else{
            throw new exception("Aucun point ajouté");
            }
    }
 }
