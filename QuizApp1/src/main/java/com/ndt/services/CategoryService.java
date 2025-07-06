/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.services;

import com.ndt.pojo.Category;
import com.ndt.utils.JdbcConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author ADMIN
 */
public class CategoryService {
    public List<Category> getCates() throws SQLException{
        // b2: thiet lap ket noi
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quizdb", "root", "1234");
            Connection conn = JdbcConnector.getInstance().connector();
            
            // b3: thuc thi truy van
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM category");
            
            List<Category> cates = new ArrayList<>();
            while (rs.next()){
                int  id = rs.getInt("id");
                String name = rs.getString("name");
                
                Category c = new Category(id, name);
                cates.add(c);
            }
            return cates;
    }
}
