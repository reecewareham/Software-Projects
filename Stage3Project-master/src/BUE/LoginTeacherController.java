package BUE;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginTeacherController {

    @FXML
    private Button cancelButton;
    @FXML
    private Label errorMessage;
    @FXML
    private TextField EmailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Button BackButton;

    public void createTeacherMain () {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TeacherMain.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void cancelButtonOnAction (ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private static Connection DatabaseConnection(){

        String fileName = "Stage3Database.db";
        String url = "jdbc:sqlite:" + fileName;
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void loginButtonOnAction (ActionEvent event) {
        Connection conn = DatabaseConnection();
        errorMessage.setText("");

        String email = EmailTextField.getText();
        String password = passwordTextField.getText();

        String DBEmail = "";
        String DBPassword = "";

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE Email=(?) AND Password=(?)")) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DBEmail = rs.getString("Email");
                DBPassword = rs.getString("Password");
            }

            if (email.equals(DBEmail) && password.equals(DBPassword)) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("TeacherMain.fxml"));
                    Stage stage = (Stage) BackButton.getScene().getWindow();
                    stage.setTitle("Teacher Main");
                    stage.setScene(new Scene(root, 660, 469));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            } else {
                errorMessage.setText("Invalid Login try again!");
            }
        } catch (SQLException e) {
            System.out.println("Fail!");
        }
    }

    public void BackButton (ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
            Stage stage = (Stage) BackButton.getScene().getWindow();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
}