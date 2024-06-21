package controllers;

import java.io.IOException;

import application.HelpException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;

public class RegisterController {
	private Stage stage;
	private Scene scene;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;
    
    @FXML
    void buttonBack(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/resources_view/LoginScreen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    public void signUpButton(ActionEvent event) {
        UserService userService = new UserService();
        try {
            userService.addUser(usernameField.getText(), passwordField.getText());
        	informationAlert(new ActionEvent(),"Yayy! User " + usernameField.getText() + " registered successfully!");
       
        } catch (HelpException e) {
        	warningAlert(new ActionEvent(), "Username "+usernameField.getText()+" already exists!!");
        }
    }
    public void warningAlert(ActionEvent event, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setContentText(errorMessage);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setHeaderText("Warning alert");
        alert.getDialogPane().setPrefSize(480, 320);
        alert.showAndWait();
    }

    public void informationAlert(ActionEvent event, String informationMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText(informationMessage);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setHeaderText("Information alert");
        alert.getDialogPane().setPrefSize(480, 320);
        alert.showAndWait();
    }
}
