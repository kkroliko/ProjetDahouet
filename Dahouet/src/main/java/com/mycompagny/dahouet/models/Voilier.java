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
public class Voilier {
   
private int voilier_id;
private int voilier_numVoile;
private Classe classe;
private String voilier_nom;

    public Voilier(int voilier_id, int voilier_numVoile, Classe classe, String voilier_nom) {
        this.voilier_id = voilier_id;
        this.voilier_numVoile = voilier_numVoile;
        this.classe = classe;
        this.voilier_nom = voilier_nom;
    }

    public Voilier(int voilier_numVoile, Classe classe, String voilier_nom) {
        this.voilier_numVoile = voilier_numVoile;
        this.classe = classe;
        this.voilier_nom = voilier_nom;
    }

    public int getVoilier_id() {
        return voilier_id;
    }

    public void setVoilier_id(int voilier_id) {
        this.voilier_id = voilier_id;
    }

    public int getVoilier_numVoile() {
        return voilier_numVoile;
    }

    public void setVoilier_numVoile(int voilier_numVoile) {
        this.voilier_numVoile = voilier_numVoile;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getVoilier_nom() {
        return voilier_nom;
    }

    public void setVoilier_nom(String voilier_nom) {
        this.voilier_nom = voilier_nom;
    }
    @Override
    public String toString() {
        return  voilier_nom ;
    }            
}
