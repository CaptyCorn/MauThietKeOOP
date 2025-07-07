package com.ndt.quizapp1;

import com.ndt.themes.DarkThemeFactory;
import com.ndt.themes.ThemeFactory;
import com.ndt.themes.ThemeManager;
import com.ndt.themes.Themes;
import com.ndt.utils.MyAlert;
import com.ndt.utils.MyStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


public class PrimaryController implements Initializable {
    @FXML private ComboBox<Themes> cbTheme;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbTheme.setItems(FXCollections.observableArrayList(Themes.values()));
    }
    
    public void changeTheme(ActionEvent event){
//        switch(this.cbTheme.getValue()){
//            case DARK:
//                ThemeManager.setThemeFactory(new DarkThemeFactory());
//                ThemeManager.applyTheme(this.cbTheme.getScene());
//                break;
//            case LIGHT:
//                cbTheme.getScene().getRoot().getStylesheets().clear();
//                cbTheme.getScene().getRoot().getStylesheets().add(App.class.getResource("light.css").toExternalForm());
//                break;
//            default:
//                cbTheme.getScene().getRoot().getStylesheets().clear();
//                cbTheme.getScene().getRoot().getStylesheets().add(App.class.getResource("style.css").toExternalForm());
//        }
        this.cbTheme.getSelectionModel().getSelectedItem().updateTheme(this.cbTheme.getScene());
    }
    
    public void handleQuestionManager(ActionEvent event) throws IOException{
        MyStage.getInstance().showStage("QuanLyCauHoi.fxml");
    }
    
    public void handlePractice(ActionEvent event){
        MyAlert.getIntance().ShowMsg("Comming soon...");
    }

    
}
