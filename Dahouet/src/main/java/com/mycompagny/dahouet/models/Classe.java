/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.dahouet.models;

/**
 *
 * @author devrok
 */
public class Classe {
    
    private int classe_id;
    private String classe_nom;
    private float classe_coef;
    private Serie serie;

    public Classe(int classe_id, String classe_nom, float classe_coef, Serie serie) {
        this.classe_id = classe_id;
        this.classe_nom = classe_nom;
        this.classe_coef = classe_coef;
        this.serie = serie;
    }

    public int getClasse_id() {
        return classe_id;
    }

    public void setClasse_id(int classe_id) {
        this.classe_id = classe_id;
    }

    public String getClasse_nom() {
        return classe_nom;
    }

    public void setClasse_nom(String classe_nom) {
        this.classe_nom = classe_nom;
    }

    public float getClasse_coef() {
        return classe_coef;
    }

    public void setClasse_coef(float classe_coef) {
        this.classe_coef = classe_coef;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
     @Override
    public String toString() {
        return classe_nom ;
    }
}
