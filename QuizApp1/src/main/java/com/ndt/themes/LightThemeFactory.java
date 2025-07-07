/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.themes;

import com.ndt.quizapp1.App;

/**
 *
 * @author admin
 */
public class LightThemeFactory implements ThemeFactory{
    public String getStyleSheet(){
        return App.class.getResource("light.css").toExternalForm();
    }
}
