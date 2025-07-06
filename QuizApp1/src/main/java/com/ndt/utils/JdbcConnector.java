/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class JdbcConnector {
    private static JdbcConnector instance;
    private final Connection conn;
    
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private JdbcConnector() throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://localhost/quizdb", "root", "1234");
    }
    
    public static JdbcConnector getInstance() throws SQLException{
        if(instance == null)
            instance = new JdbcConnector();
        return instance;
    }
    
    public Connection connector(){
        return this.conn;
    }
    
    public void close() throws SQLException{
        if(this.conn != null)
            this.conn.close();
    }
}
