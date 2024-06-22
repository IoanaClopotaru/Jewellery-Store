package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class JewelleryStoreController extends Controller{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    void goBaackButton(ActionEvent event) throws IOException {
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources_view/ComboBox.fxml")); 
		root = loader.load();
		ComboBoxController comboBoxController= loader.getController();
		comboBoxController.greetUser(Controller.username);
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
	@FXML
	void addToCartButton(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/resources_view/AddToCart.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	   @FXML
	    void goBackToCombo(ActionEvent event) throws IOException {
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources_view/ComboBox.fxml")); 
			root = loader.load();
			ComboBoxController comboBoxController= loader.getController();
			comboBoxController.greetUser(Controller.username);
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }

}
