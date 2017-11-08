/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dahouet.dao;

import com.mycompagny.dahouet.models.Club;
import com.mycompagny.dahouet.models.Proprietaire;
import com.mycompagny.dahouet.models.Voilier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author devrok
 */
public class ProprietaireDAO {
    
      public static void create(Proprietaire proprietaire){
        try {
            Connection c = DBConnect.getConnection();
            PreparedStatement stm;
            
            stm = c.prepareStatement("INSERT INTO proprietaire (proprietaire_nom,club_id,voilier_id) VALUES(?,?,?)");
            stm.setString(1, proprietaire.getProprietaire_nom());
            stm.setInt(2, proprietaire.getClub().getClub_id());
            stm.setInt(3,proprietaire.getVoilier().getVoilier_id());
            
            
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

     }
        
     public static ArrayList<Proprietaire> findAll() {
        try {
            ArrayList<Proprietaire> proprietaires = new ArrayList<>();
            
            Connection c = DBConnect.getConnection();
            Statement stm;
            stm=c.createStatement();
            String sql ="SELECT * FROM proprietaire";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("proprietaire_id");
                String nom = rs.getString("proprietaire_nom");
                Club club=ClubDAO.findOneById(rs.getInt("club_id"));
                Voilier voilier=VoilierDAO.findOneById(rs.getInt("voilier_id"));
                Proprietaire proprietaire = new Proprietaire(id,club,nom,voilier);
                proprietaires.add(proprietaire);
            }
            return proprietaires;
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   
}
