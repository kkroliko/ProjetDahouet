/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dahouet.dao;

import com.mycompagny.dahouet.models.Club;
import java.sql.Connection;
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
public class ClubDAO {
     public static ArrayList<Club> findAll() {
        try {
            ArrayList<Club> clubs = new ArrayList<>();
            
            Connection c = DBConnect.getConnection();
            Statement stm;
            stm=c.createStatement();
            String sql ="SELECT * FROM club";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("club_id");
                String nom = rs.getString("club_nom");
                Club club = new Club(id,nom);
                clubs.add(club);
            }
            return clubs;
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Club findOneById(int id) {
         try {
             Club club = null;
             Connection c = DBConnect.getConnection();
             Statement stm;
             stm=c.createStatement();
             String sql ="SELECT * FROM club WHERE club_id="+id;
             ResultSet rs =stm.executeQuery(sql);
             
             if(rs.next()){
                 String nom=rs.getString("club_nom");
                 club = new Club(id,nom);
             }
             
             return club;
         } catch (SQLException ex) {
             Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return null;
    }  
}
    

