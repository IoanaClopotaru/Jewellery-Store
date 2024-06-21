package controllers;

import java.io.IOException;
import application.HelpException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;
import javafx.scene.Node;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private PasswordField passwordField;

	@FXML
	private TextField usernameField;
	private String username;

	@FXML
	void loginButton(ActionEvent event) throws IOException{
		UserService userService = new UserService();
		try {
			if (userService.findUser(usernameField.getText(), passwordField.getText()) != null) {
				username = usernameField.getText();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources_view/ComboBox.fxml"));
				root = loader.load();
				ComboBoxController comboBoxController= loader.getController();
				comboBoxController .greetUser(username);
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Jewellery Store");
				stage.show();
			}
		} catch (HelpException e) {
			warningAlert(new ActionEvent(), "The passwoord is incorrect.");
		}
		
	}

	@FXML
	void signUpButton(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/resources_view/RegisterScreen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	private void warningAlert(ActionEvent event, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setContentText(errorMessage);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setHeaderText("Warning alert");
        alert.getDialogPane().setPrefSize(480, 320);
        alert.showAndWait();
    }
}