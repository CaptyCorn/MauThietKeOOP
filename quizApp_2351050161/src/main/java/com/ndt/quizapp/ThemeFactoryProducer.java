/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

/**
 *
 * @author admin
 */
public class ThemeFactoryProducer {
    public static ThemeFactory getTheme(ThemeType themeType) {
        return switch (themeType) {
            case DEFAULT_THEME -> new DefaultThemeFactory();
            case DARK_THEME -> new DarkThemeFactory();
            case LIGHT_THEME -> new LightThemeFactory();
        };
    }
}
