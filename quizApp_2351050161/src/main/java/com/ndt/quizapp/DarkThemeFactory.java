/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

/**
 *
 * @author admin
 */
public class DarkThemeFactory implements ThemeFactory{
    
    @Override
    public String getBackgroudStyle() {
        return "-fx-background-color: #121212; -fx-padding: 10";
    }

    @Override
    public String getTitleStyle() {
        return "-fx-font-size: 40; -fx-font-weight: bold; -fx-fill: #FFFFFF; -fx-stroke: gold; -fx-stroke-width: 3";
    }

    @Override
    public String getButtonStyle() {
        return "-fx-background-color: #333333; -fx-text-fill: #FFFFFF; -fx-font-size: 14";
    }
    
}
