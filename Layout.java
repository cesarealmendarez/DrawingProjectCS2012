package project;

import javafx.application.Application; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.geometry.Pos; 
import javafx.scene.Group; 
import javafx.scene.Node; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.ColorPicker; 
import javafx.scene.control.ComboBox; 
import javafx.scene.control.Label; 
import javafx.scene.control.Slider;
import javafx.scene.control.TextField; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.StackPane; 
import javafx.scene.shape.Circle; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.stage.Stage; 

public class Layout extends Application{
		
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 1000, 1000);
		
		mainStage.setScene(scene);
		mainStage.show();
	}
	
}