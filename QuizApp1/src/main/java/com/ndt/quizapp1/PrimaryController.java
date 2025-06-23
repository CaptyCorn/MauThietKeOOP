package com.ndt.quizapp1;

import com.ndt.utils.MyAlert;
import com.ndt.utils.MyStage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class PrimaryController {
    public void handleQuestionManager(ActionEvent event) throws IOException{
        MyStage.getInstance().showStage("QuanLyCauHoi.fxml");
    }
    
    public void handlePractice(ActionEvent event){
        MyAlert.getIntance().ShowMsg("Comming soon...");
    }
}
