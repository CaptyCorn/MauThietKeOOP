/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

/**
 *
 * @author admin
 */
public class DefaultThemeFactory implements ThemeFactory{

    @Override
    public String getBackgroudStyle() {
        return "-fx-background-color: lightpink; -fx-padding: 10";
    }

    @Override
    public String getTitleStyle() {
        return "-fx-font-size: 40; -fx-font-weight: bold; -fx-fill: red; -fx-stroke: gold; -fx-stroke-width: 3";
    }

    @Override
    public String getButtonStyle() {
        return "-fx-background-color: darkblue; -fx-text-fill: white; -fx-font-size: 14";
    }
    
}
