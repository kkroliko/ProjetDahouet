/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dahouet.dao;

import com.mycompagny.dahouet.models.Classe;
import com.mycompagny.dahouet.models.Serie;
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
public class ClasseDAO {
    
public static ArrayList<Classe> findallFromSerieId(int serieId) {
        try {
            ArrayList<Classe>classes = new ArrayList();
            Serie serie;
            Connection c = DBConnect.getConnection();
            Statement stm;
            String sql ="SELECT * FROM Classe WHERE serie_id="+serieId;
            stm=c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("classe_id");
                String nom=rs.getString("classe_nom");
                float coef = rs.getFloat("classe_coef");
                serie = SerieDAO.findOnebyId(serieId);
                Classe classe = new Classe(id,nom,coef,serie);
                classes.add(classe);
            }
            return classes;
        } catch (SQLException ex) {
            Logger.getLogger(ClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Classe findOneById(int id) throws SQLException{
        
        Classe classe =null;
        Connection c = DBConnect.getConnection();
        Statement stm;
       stm=c.createStatement();
       String sql="SELECT * FROM Classe WHERE classe_id="+id;
       ResultSet rs = stm.executeQuery(sql);
       if(rs.next()){
           String nom=rs.getString("classe_nom");
          float coeff = rs.getFloat("classe_coef");
          Serie serie = SerieDAO.findOnebyId(rs.getInt("serie_id"));
          classe = new Classe(id,nom,coeff,serie);
       }
        return classe;
    }
}
