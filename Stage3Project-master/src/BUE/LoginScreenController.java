package BUE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class LoginScreenController {

    @FXML
    private Button StudentLogin;

    @FXML
    private Button StaffLogin;

    @FXML
    private Button ExitButton;

    public void StudentLogin (ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginStudent.fxml"));
            Stage stage = (Stage) StudentLogin.getScene().getWindow();
            stage.setTitle("Student Login");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    public void StaffLogin (ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginTeacher.fxml"));
            Stage stage = (Stage) StaffLogin.getScene().getWindow();
            stage.setTitle("Staff Login");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    public void ExitButton (ActionEvent event){
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
}
