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
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600);
			
		scene.setOnMouseClicked(event -> {
			Circle newCircle = new Circle(event.getX(), event.getY(), 15);
			root.getChildren().add(newCircle);
		});
		
		mainStage.setScene(scene);
		mainStage.show();
		 
//		StackPane root = new StackPane();
//		Scene scene = new Scene(root, 1000, 1000);
		
//		HBox box = new HBox(); 
//		box.setStyle("-fx-background-color: gray"); 
//		box.setPrefWidth(2000); 
//		box.setMaxWidth(2000); 
//		box.setPrefHeight(200); 
//		box.setMaxHeight(200); 
//		box.setTranslateY(-400); 
//		root.getChildren().add(box);
		
//		HBox box2 = new HBox(); 
//		box2.setStyle("-fx-background-color: red"); 
//		box2.setPrefWidth(2000); 
//		box2.setMaxWidth(2000); 
//		box2.setPrefHeight(2000); 
//		box2.setMaxHeight(2000); 
//		box2.setTranslateY(100);
//		 	
//		Group group = new Group();
//		box2.setOnMouseClicked((click) -> { 
//			// GET X AND Y COORDINATES 	
//			double xPosition = click.getX();
//			double yPositon = click.getY();
//			// CREATE AND ADD CIRCLE TO HBOX box2
//			Circle newCircle = new Circle(xPosition, yPositon, 15);
//		});
//		
//		box2.getChildren().add(group);
//		root.getChildren().add(box2);
		
		
		
//		mainStage.setScene(scene);
//		mainStage.show();
	}
	
}