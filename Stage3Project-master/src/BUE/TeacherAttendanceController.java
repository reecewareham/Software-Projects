package BUE;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherAttendanceController implements Initializable {
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, String> notesColumn;
    @FXML
    private TableColumn<Student, String> statusColumn;
    @FXML
    private Button presentButton;
    @FXML
    private Button absentButton;
    @FXML
    private TextField studentName;
    @FXML
    private Text errorMessage;
    @FXML
    private Button BackButton;

    private String absent = "Absent";
    private String present = "Present";

    public static void CreateStudent(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Sets up the columns in the table
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("StudentName"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Notes"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Status"));

        //Loads data
        tableView.setItems(getStudent());
        tableView.setEditable(true);
    }

    public ObservableList<Student> getStudent() {
        ObservableList <Student> student = FXCollections.observableArrayList();
        student.add(new Student("Oliver", "18:15", present));
        student.add(new Student("Michael", "18:15", present));
        student.add(new Student("James", "18:15", absent));

        return student;
    }

    public void onAbsentButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Absent.fxml"));
            Stage stage = (Stage) absentButton.getScene().getWindow();
            stage.setTitle("Attendance");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void onPresentButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Present.fxml"));
            Stage stage = (Stage) presentButton.getScene().getWindow();
            stage.setTitle("Attendance");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void BackButton (ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TeacherLecture.fxml"));
            Stage stage = (Stage) BackButton.getScene().getWindow();
            stage.setTitle("Lecture Main");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
}
