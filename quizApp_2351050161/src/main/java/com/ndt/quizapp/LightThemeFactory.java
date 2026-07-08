/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

/**
 *
 * @author admin
 */
public class LightThemeFactory implements ThemeFactory{

    @Override
    public String getBackgroudStyle() {
        return "-fx-background-color: #FFFFFF; -fx-padding: 10";
    }

    @Override
    public String getTitleStyle() {
        return "-fx-font-size: 40; -fx-font-weight: bold; -fx-fill: #000000; -fx-stroke: gold; -fx-stroke-width: 3";
    }

    @Override
    public String getButtonStyle() {
        return "-fx-background-color: #E0E0E0; -fx-text-fill: #000000; -fx-font-size: 14; -fx-font-family: \"Verdana\"";
    }
    
}
