package BUE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StudentQRSuccessController {

    @FXML
    private Button BackButton;

    public void BackButton (ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("StudentMain.fxml"));
            Stage stage = (Stage) BackButton.getScene().getWindow();
            stage.setTitle("Student Main");
            stage.setScene(new Scene(root, 660, 469));
            stage.show();
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

}
