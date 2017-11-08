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
public class Club {
    
    private int club_id;
    private String club_nom;

    public Club(int club_id, String club_nom) {
        this.club_id = club_id;
        this.club_nom = club_nom;
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }

    public String getClub_nom() {
        return club_nom;
    }

    public void setClub_nom(String club_nom) {
        this.club_nom = club_nom;
    }

    @Override
    public String toString() {
        return club_nom;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
