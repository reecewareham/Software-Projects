package BUE;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TeacherMainController {


    @FXML
    private Button ButtonTeacherMainLogout;
    @FXML
    private Button ButtonLecture1;
    @FXML
    private Button ButtonLecture2;
    @FXML
    private Button ButtonLecture3;
    @FXML
    private Button ButtonLecture4;


    public void ButtonTeacherMainLogoutOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginTeacher.fxml"));
            Stage stage = (Stage) ButtonTeacherMainLogout.getScene().getWindow();
            stage.setTitle("Teacher Login");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ButtonLecture1OnAction(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("TeacherLecture.fxml"));
            Stage stage = (Stage) ButtonLecture1.getScene().getWindow();
            stage.setTitle("Teacher Lecture");
            stage.setScene((new Scene(root,660,469)));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ButtonLecture2OnAction(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("TeacherLecture.fxml"));
            Stage stage = (Stage) ButtonLecture2.getScene().getWindow();
            stage.setTitle("Teacher Lecture");
            stage.setScene((new Scene(root,660,469)));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ButtonLecture3OnAction(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("TeacherLecture.fxml"));
            Stage stage = (Stage) ButtonLecture3.getScene().getWindow();
            stage.setTitle("Teacher Lecture");
            stage.setScene((new Scene(root,660,469)));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ButtonLecture4OnAction(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("TeacherLecture.fxml"));
            Stage stage = (Stage) ButtonLecture4.getScene().getWindow();
            stage.setTitle("Teacher Lecture");
            stage.setScene((new Scene(root,660,469)));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
