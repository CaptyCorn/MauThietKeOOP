/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ndt.quizapp1;

import com.ndt.pojo.Category;
import com.ndt.pojo.Level;
import com.ndt.services.CategoryService;
import com.ndt.services.LevelService;
import com.ndt.utils.JdbcConnector;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuanLyCauHoiController implements Initializable {
    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevel;
    @FXML private VBox vboxChoice;

    private static final CategoryService cateService = new CategoryService();
    private static final LevelService lvlService = new LevelService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(cateService.getCates()));
            this.cbLevel.setItems(FXCollections.observableList(lvlService.getLevel()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public void handleAddChoice(ActionEvent event){
        HBox h = new HBox();
        h.getStyleClass().add("Main");
        
        RadioButton rbt = new RadioButton();
        TextField tf = new TextField();
        
        h.getChildren().addAll(rbt, tf);
        this.vboxChoice.getChildren().add(h);
    }
    
}
