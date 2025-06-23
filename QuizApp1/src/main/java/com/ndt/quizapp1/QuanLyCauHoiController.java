/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ndt.quizapp1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuanLyCauHoiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // b1: nap driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // b2: thiet lap ket noi
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quizdb", "root", "root");
            
            // b3: thuc thi truy van
            Statement stm = conn.createStatement();
            stm.executeQuery("SELECT * FROM category");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
}
