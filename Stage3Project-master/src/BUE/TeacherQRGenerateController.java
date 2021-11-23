package BUE;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class TeacherQRGenerateController {

    @FXML
    private Button FinishButton;

    public void FinishOnAction(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("TeacherLecture.fxml"));
            Stage stage = (Stage) FinishButton.getScene().getWindow();
            stage.setTitle("Teacher Lecture");
            stage.setScene((new Scene(root,660,469)));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
