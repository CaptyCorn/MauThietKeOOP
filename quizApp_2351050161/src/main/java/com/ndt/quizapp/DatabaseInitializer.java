/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.quizapp;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DatabaseInitializer {
    public static void initDB() throws SQLException {
        Connection connection = JdbcConnector.getInstance().connect();
    }
}
