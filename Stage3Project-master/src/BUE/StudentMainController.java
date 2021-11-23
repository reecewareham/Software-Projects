package BUE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMainController {

    @FXML
    private Button QRButton;

    @FXML
    private Button LogoutButton;

    public void QRScanner (ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("StudentQRScanner.fxml"));
            Stage stage = (Stage) QRButton.getScene().getWindow();
            stage.setTitle("QR Scanner");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    public void StudentMainLogout (ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginStudent.fxml"));
            Stage stage = (Stage) LogoutButton.getScene().getWindow();
            stage.setTitle("Student Login");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            System.out.println("Fail");
        }

    }

}
