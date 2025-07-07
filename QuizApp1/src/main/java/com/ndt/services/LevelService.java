/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.services;

import com.ndt.pojo.Category;
import com.ndt.pojo.Level;
import com.ndt.utils.JdbcConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author admin
 */
public class LevelService {
     public List<Level> getLevel() throws SQLException{
        // b2: thiet lap ket noi
            Connection conn = JdbcConnector.getInstance().connector();
            
            // b3: thuc thi truy van
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM level");
            
            List<Level> levels = new ArrayList<>();
            while (rs.next()){
                int  id = rs.getInt("id");
                String name = rs.getString("name");
                String note = rs.getString("note");
                
                Level l = new Level(id, name, note);
                levels.add(l);
            }
            return levels;
    }
}
