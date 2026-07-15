/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ndt.quizapp;

import com.ndt.pojo.Choice;
import com.ndt.pojo.Question;
import com.ndt.repositories.QuestionRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class QuizApp_2351050161 extends Application{
    
    private Stage mainStage;
    private ThemeFactory currThemeFactory = new DefaultThemeFactory();
    private ThemeType currThemeType = ThemeType.DEFAULT_THEME;
    
    private int currQuestion = 0;
    private List<Question> lstQuestion = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        DatabaseInitializer.initDB();
        
        mainStage = stage;
        currThemeFactory = ThemeFactoryProducer.getTheme(currThemeType);
        showHome();
    }

    private void showHome() {
        Label lblTitle = new Label("Quizz App");
        lblTitle.setStyle(currThemeFactory.getTitleStyle());
        
        Button btnQuestion = new Button("Quản lý câu hỏi.");
        btnQuestion.setPrefWidth(250);
        btnQuestion.setStyle(currThemeFactory.getButtonStyle());
        
        Button btnPractice = new Button("Luyện tập câu hỏi.");
        btnPractice.setPrefWidth(250);
        btnPractice.setStyle(currThemeFactory.getButtonStyle());
        
        Button btnExam = new Button("Kiểm tra câu hỏi.");
        btnExam.setPrefWidth(250);
        btnExam.setStyle(currThemeFactory.getButtonStyle());
        
        btnQuestion.setOnAction(e -> showQuestionForm());
        
        btnPractice.setOnAction(e -> showPracticeForm());
        
        btnExam.setOnAction(e -> MyAlert.getInstance().showAlert("Chào mứng đến kiểm tra bài thi.", 
                Alert.AlertType.INFORMATION));
        
        ComboBox<ThemeType> cbBox = new ComboBox<>();
        cbBox.getItems().addAll(ThemeType.DEFAULT_THEME, ThemeType.DARK_THEME, ThemeType.LIGHT_THEME);
        cbBox.setPrefWidth(250);
        cbBox.setValue(currThemeType);
        cbBox.setStyle(currThemeFactory.getButtonStyle());
        
        cbBox.setOnAction(e -> {
            currThemeType = cbBox.getValue();
            currThemeFactory = ThemeFactoryProducer.getTheme(currThemeType);
            showHome();
        });
        
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setStyle(currThemeFactory.getBackgroudStyle());
        root.getChildren().addAll(lblTitle, btnQuestion, btnPractice, btnExam, cbBox);
        
        Scene scene = new Scene(root, 640, 480);
        this.mainStage.setScene(scene);
        this.mainStage.show();
    }

    private void showQuestionForm() {
        Label lblTitle = new Label("Quản lý câu hỏi");
        lblTitle.setStyle(currThemeFactory.getTitleStyle());
        
        TextField txtContent =  new TextField();
        txtContent.setMaxWidth(500);
        txtContent.setPromptText("Nhập nội dung câu hỏi");
        
        TextField txtHint =  new TextField();
        txtHint.setMaxWidth(500);
        txtHint.setPromptText("Gợi ý cho câu hỏi");
        
        ComboBox cbCategory = new ComboBox();
        cbCategory.getItems().addAll("Grammar", "Vocabulary", "Reading");
        cbCategory.setValue("Danh mục");
        
        ComboBox cbLevel = new ComboBox();
        cbLevel.getItems().addAll("Easy", "Medium", "Hard");
        cbLevel.setValue("Cấp độ");
        
        HBox hbDanhMuc = new HBox(10);
        hbDanhMuc.setAlignment(Pos.CENTER);
        hbDanhMuc.getChildren().addAll(cbCategory, cbLevel);
        
        ToggleGroup rbGroup = new ToggleGroup();
        
        RadioButton rbA = new RadioButton();
        rbA.setToggleGroup(rbGroup);
        TextField txtAnswerA = new TextField();
        txtAnswerA.setPromptText("Đáp án A");
        
        RadioButton rbB = new RadioButton();
        rbB.setToggleGroup(rbGroup);
        TextField txtAnswerB = new TextField();
        txtAnswerB.setPromptText("Đáp án B");
        
        HBox row1 = new HBox(10, rbA, txtAnswerA, rbB, txtAnswerB);
        
        RadioButton rbC = new RadioButton();
        rbC.setToggleGroup(rbGroup);
        TextField txtAnswerC = new TextField();
        txtAnswerC.setPromptText("Đáp án C");
        
        RadioButton rbD = new RadioButton();
        rbD.setToggleGroup(rbGroup);
        TextField txtAnswerD = new TextField();
        txtAnswerD.setPromptText("Đáp án D");
        
        HBox row2 = new HBox(10, rbC, txtAnswerC, rbD, txtAnswerD);
        
        rbA.setUserData("A");
        rbB.setUserData("B");
        rbC.setUserData("C");
        rbD.setUserData("D");
        
        Button btnSave = new Button("Lưu câu hỏi");
        btnSave.setOnAction(e -> {
            if (txtContent.getText().trim().isEmpty() || txtHint.getText().trim().isEmpty()) {
                MyAlert.getInstance().showError("Bạn chưa nhập nội dung hoặc là gợi ý!");
                return;
            }
            
            if (cbCategory.getValue() == null || cbLevel.getValue() == null) {
                MyAlert.getInstance().showError("Bạn chưa chọn danh mục hoặc cấp độ!");
                return;
            }
            
            if (txtAnswerA.getText().trim().isEmpty() || 
                    txtAnswerB.getText().trim().isEmpty() || 
                    txtAnswerC.getText().trim().isEmpty() || 
                    txtAnswerD.getText().trim().isEmpty()) {
                MyAlert.getInstance().showError("Bạn chưa nhập câu trả lời1");
                return;
            }
            
            if (rbGroup.getSelectedToggle() == null) {
                MyAlert.getInstance().showError("Bạn chưa chọn đáp án đúng!");
                return;
            }
            
            String correctAnswer = rbGroup.getSelectedToggle().getUserData().toString();
            ArrayList<Choice> choices = new ArrayList<>();
            choices.add(new Choice(txtAnswerA.getText().trim(), correctAnswer.equals("A")));
            choices.add(new Choice(txtAnswerB.getText().trim(), correctAnswer.equals("B")));
            choices.add(new Choice(txtAnswerC.getText().trim(), correctAnswer.equals("C")));
            choices.add(new Choice(txtAnswerD.getText().trim(), correctAnswer.equals("D")));
            
            Question.Builder builder = new Question.Builder()
                    .category(cbCategory.getValue().toString())
                    .content(txtContent.getText().trim())
                    .hint(txtHint.getText().trim())
                    .choices(choices)
                    .level(cbLevel.getValue().toString());
            
            Question question = new Question(builder);
            
            try {
                QuestionRepository questionRepo = new QuestionRepository();
                Boolean result = questionRepo.addQuestion(question);
                if (result) {
                    MyAlert.getInstance().showAlert("Thêm câu hỏi thành công.", Alert.AlertType.INFORMATION);
                    txtContent.clear();
                    txtHint.clear();
                    txtAnswerA.clear();
                    txtAnswerB.clear();
                    txtAnswerC.clear();
                    txtAnswerD.clear();
                    cbCategory.setValue("Danh mục");
                    cbLevel.setValue("Cấp độ");
                    rbGroup.getToggles().clear();
                }
                else MyAlert.getInstance().showAlert("Thêm câu hỏi không thành công!", Alert.AlertType.ERROR);
            } catch (SQLException ex) {
                System.getLogger(QuizApp_2351050161.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
        
        Button returnHomeForm = new Button("Quay về trang chủ");
        returnHomeForm.setOnAction(e -> showHome());
             
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setStyle(currThemeFactory.getBackgroudStyle());
        root.getChildren().addAll(lblTitle, txtContent, txtHint, hbDanhMuc, row1, row2, btnSave, returnHomeForm);
        
        Scene scene = new Scene(root, 640, 480);
        this.mainStage.setScene(scene);
        this.mainStage.show();
    }

    private void showPracticeForm() {
        initDB();
        
        Label lbl = new Label("Câu hỏi " + currQuestion + " / " + lstQuestion.size());
        
        Label lblContent = new Label(lstQuestion.get(currQuestion).getContent());
        lblContent.prefWidth(500);
        
        VBox answerBox = new VBox();
        answerBox.setAlignment(Pos.TOP_LEFT);
        
        ToggleGroup rbAnswerGroup = new ToggleGroup();
        for (Choice choice : lstQuestion.get(currQuestion).getChoice()) {
            RadioButton rbChoice = new RadioButton(choice.getContent());
            rbChoice.setUserData(choice);
            rbChoice.setToggleGroup(rbAnswerGroup);
            answerBox.getChildren().add(rbChoice);
        }
        
        Button btnAnswer = new Button("Trả lời");
        btnAnswer.setStyle(currThemeFactory.getButtonStyle());
        
        Button btnNextQuestion = new Button("Câu tiếp theo");
        btnNextQuestion.setStyle(currThemeFactory.getButtonStyle());
        btnNextQuestion.setOnAction(e -> showHome());
        
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setStyle(currThemeFactory.getBackgroudStyle());
        root.getChildren().addAll(lbl, lblContent, answerBox, btnAnswer, btnNextQuestion);
        
        Scene scene = new Scene(root, 640, 480);
        this.mainStage.setScene(scene);
        this.mainStage.show();
    }
    
    private void initDB() {
//        List<Choice> choices = List.of(new Choice("AA", Boolean.TRUE), new Choice("BB", Boolean.FALSE), 
//                new Choice("CC", Boolean.FALSE), new Choice("DD", Boolean.FALSE));
//        
//        List<Question> questions = List.of(new Question(1, "Cau 11", "level", "category", "", "", choices));

        QuestionRepository repo = new QuestionRepository();
        
        this.lstQuestion = repo.getListQuestion(null, null, null, 1);
    }
    
}
