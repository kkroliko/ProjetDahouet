/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dahouet.dao;

import com.mycompagny.dahouet.models.Classe;
import com.mycompagny.dahouet.models.Club;
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


public class VoilierDAO {
    
    
     public static void create(Voilier voilier){
        try {
            Connection c = DBConnect.getConnection();
            PreparedStatement stm;
            
            stm = c.prepareStatement("INSERT INTO Voilier (voilier_nom,classe_id,voilier_numVoile) VALUES(?,?,?)");
            stm.setString(1, voilier.getVoilier_nom());
            stm.setInt(2, voilier.getClasse().getClasse_id());
            stm.setInt(3,voilier.getVoilier_numVoile());
            
            
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

     }
    
    public static Voilier findOneById(int id) {
         try {
             Voilier voilier = null;
             Connection c = DBConnect.getConnection();
             Statement stm;
             stm=c.createStatement();
             String sql ="SELECT * FROM Voilier WHERE voilier_id="+id;
             ResultSet rs =stm.executeQuery(sql);
             
             if(rs.next()){
                 int voilier_id = rs.getInt("voilier_id");
                 int voilier_numVoile = rs.getInt("voilier_numVoile");
                 Classe classe = ClasseDAO.findOneById(rs.getInt("classe_id"));
                 String voilier_nom = rs.getString("voilier_nom");
                
                 voilier = new Voilier(voilier_id,voilier_numVoile,classe,voilier_nom);
             }
             
             return voilier;
         } catch (SQLException ex) {
             Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return null;
    }
    
    public static ArrayList<Voilier> findAll() {
        try {
            ArrayList<Voilier> voiliers = new ArrayList<>();
     
            Connection c = DBConnect.getConnection();
            Statement stm;
            stm=c.createStatement();
            String sql ="SELECT * FROM Voilier";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("voilier_id");
                int numVoile = rs.getInt("voilier_numVoile");
                String nom = rs.getString("voilier_nom");
                Classe classe=ClasseDAO.findOneById(rs.getInt("classe_id"));
                Voilier Voilier = new Voilier(id,numVoile,classe,nom);
                voiliers.add(Voilier);
            }
            return voiliers;
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
}
