/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author admin
 */
public class MyAlert {
    private Alert alert;
    private static MyAlert instance;
    
    private MyAlert() {
        alert = new Alert(Alert.AlertType.INFORMATION);
    }
    
    public static MyAlert getInstance() {
        if (instance == null) 
            instance = new MyAlert();
        return instance;
    }
    
    public Optional<ButtonType> showAlert(String content, Alert.AlertType type) {
        
        alert.setAlertType(type);
        alert.setTitle("Quizz App");
        alert.setContentText(content);
        alert.setHeaderText("Thông báo");
        
        return alert.showAndWait();
    }
    
    public Optional<ButtonType> showError(String content) {
        
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setTitle("Quizz App");
        alert.setContentText(content);
        alert.setHeaderText("Thông báo");
        
        return alert.showAndWait();
    }
}
