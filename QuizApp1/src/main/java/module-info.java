module com.ndt.quizapp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.ndt.quizapp1 to javafx.fxml;
    exports com.ndt.quizapp1;
}
