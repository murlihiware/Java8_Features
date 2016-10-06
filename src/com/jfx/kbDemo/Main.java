package com.jfx.kbDemo;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			showBirthdayStatistics();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void showBirthdayStatistics() {
	    try {

	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("BirthDate.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        Stage dialogStage = new Stage();
	        Scene scene = new Scene(page);
	        scene.getStylesheets().add("application.css");
	        dialogStage.setScene(scene);
	        BirthdayStatisticsController controller = loader.getController();
	        dialogStage.show();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public static void main(String[] args) {
		launch(args);
	}
}
