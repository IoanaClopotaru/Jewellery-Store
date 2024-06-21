package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.UserGreetings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ComboBoxController implements Initializable {
	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private Pane contentArea;

	@FXML
	private Label selection;

	@FXML
	private Label nameLabel;

	private Parent root;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		String[] items = { "Ring", "Necklace", "Bracelet", "Earrings" };
		comboBox.getItems().addAll(items);
		comboBox.setOnAction(event -> {
			String data = comboBox.getSelectionModel().getSelectedItem().toString();
			selection.setText(data);

			String addItem = comboBox.getValue();
			comboBox.getItems().add(addItem);
		});

	}

	@FXML
	private void loadItems(ActionEvent event) {
		String selectedPage = comboBox.getValue();
		switch (selectedPage) {
		case "Ring":
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/resources_view/JewelleryRing.fxml"));
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "Bracelet":
			try {
				root = FXMLLoader.load(getClass().getResource("/resources_view/JewelleryBracelet.fxml"));
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "Necklace":
			try {
				root = FXMLLoader.load(getClass().getResource("/resources_view/JewelleryNecklace.fxml"));
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "Earrings":
			try {
				root = FXMLLoader.load(getClass().getResource("/resources_view/JewelleryEarrings.fxml"));
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("No matching case found for: " + selectedPage);
			break;
		}
	}

	private UserGreetings userGreeting() {
        String regex = "^[a-z].*";
        Pattern pattern = Pattern.compile(regex);
        List<UserGreetings> userGreetings = new ArrayList<>();

        for (UserGreetings greeting : UserGreetings.values()) {
            String value = greeting.getUserHello();
            Matcher matcher = pattern.matcher(value);
            if (matcher.matches()) {
                userGreetings.add(greeting);
            }
        }

        Random random = new Random();
        int randomIndex = random.nextInt(userGreetings.size());
        return userGreetings.get(randomIndex);
    }

    public void greetUser(String username) {
        UserGreetings greeting = userGreeting();
        String userHello = capitalizeFirstLetter(greeting.getUserHello());
        nameLabel.setText(userHello + ", " + username + "!");
    }

    private String capitalizeFirstLetter(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ");

        for (String word : words) {
            if (!word.isEmpty()) {
                String firstLetter = word.substring(0, 1).toUpperCase();
                String remainingLetters = word.substring(1).toLowerCase();
                result.append(firstLetter).append(remainingLetters).append(" ");
            }
        }

        return result.toString().trim();
    }
}