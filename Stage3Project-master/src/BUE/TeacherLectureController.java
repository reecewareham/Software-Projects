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
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TeacherLectureController {

    @FXML
    private Button ButtonTeacherViewAttendance;
    @FXML
    private Button ButtonTeacherLectureBack;
    @FXML
    private Button ButtonTeacherNotifyStudents;
    @FXML
    private Label TeacherNotifyStudentsMessage;
    @FXML
    private Button QRGenerateButton;

    public void TeacherViewAttendanceOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TeacherAttendance.fxml"));
            Stage stage = (Stage) ButtonTeacherViewAttendance.getScene().getWindow();
            stage.setTitle("Attendance");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ButtonTeacherLectureBackOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TeacherMain.fxml"));
            Stage stage = (Stage) ButtonTeacherLectureBack.getScene().getWindow();
            stage.setTitle("Teacher Main");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ButtonTeacherNotifyStudentsOnAction(ActionEvent event) {
        TeacherNotifyStudentsMessage.setText("DONE!");
        TeacherNotifyStudentsMessage.setStyle("-fx-background-color: white");


    }

    public void GenerateQROnAction(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("TeacherQRGenerate.fxml"));
            Stage stage = (Stage) QRGenerateButton.getScene().getWindow();
            stage.setTitle("QR Generator");
            stage.setScene((new Scene(root,660,469)));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }



}

