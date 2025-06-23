/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.utils;

import javafx.scene.control.Alert;

/**
 *
 * @author admin
 */
public class MyAlert {
    private static MyAlert instance;
    private final Alert alert;
    
    private MyAlert(){
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("hello");
        alert.setHeaderText("hello");
    }
    
    public static MyAlert getIntance(){
        if(instance == null)
            instance = new MyAlert();
        return instance;
    }
    
    public void ShowMsg(String msg){
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
