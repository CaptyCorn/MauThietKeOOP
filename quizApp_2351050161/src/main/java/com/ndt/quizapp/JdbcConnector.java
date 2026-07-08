/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class JdbcConnector {
    private static JdbcConnector instance;
    private Connection connection;
    
    private JdbcConnector() {
        
    }
    
    public static JdbcConnector getInstance() {
        if (instance == null)
            instance = new JdbcConnector();
        return instance;
    }
    
    public Connection connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:quiz_app.db");
        return connection; 
    }
}
