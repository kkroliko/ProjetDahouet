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
public class Proprietaire {
    private int proprietaire_id;
    private Club club;
    private String proprietaire_nom;
    private Voilier voilier;

    public Proprietaire(int proprietaire_id, Club club, String proprietaire_nom, Voilier voilier) {
        this.proprietaire_id = proprietaire_id;
        this.club = club;
        this.proprietaire_nom = proprietaire_nom;
        this.voilier = voilier;
        
    }

    public Proprietaire(Club club, String proprietaire_nom, Voilier voilier) {
        this.club = club;
        this.proprietaire_nom = proprietaire_nom;
        this.voilier = voilier;
    }

    public int getProprietaire_id() {
        return proprietaire_id;
    }

    public void setProprietaire_id(int proprietaire_id) {
        this.proprietaire_id = proprietaire_id;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getProprietaire_nom() {
        return proprietaire_nom;
    }

    public void setProprietaire_nom(String proprietaire_nom) {
        this.proprietaire_nom = proprietaire_nom;
    }

    public Voilier getVoilier() {
        return voilier;
    }

    public void setVoilier(Voilier voilier) {
        this.voilier = voilier;
    }
      @Override
    public String toString() {
        return proprietaire_nom ;
    }
}

