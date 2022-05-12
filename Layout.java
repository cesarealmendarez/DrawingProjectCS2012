package project;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.geometry.Pos; 
import javafx.scene.Group; 
import javafx.scene.Node; 
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker; 
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label; 
import javafx.scene.control.Slider;
import javafx.scene.control.TextField; 
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.stage.Stage; 

public class Layout extends Application{
		
	String shapeType = "";
	boolean shapeTypeSet = false;
	double circleRadius = 0.0;
	boolean circleRadiusSet = false;
	Color circleColor = Color.WHITE;
	boolean circleColorSet = false;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Group root = new Group();
				
		// ALERT DIALOG
		Dialog<String> dialog = new Dialog<String>();
		dialog.setTitle("Alert");
		ButtonType confirmDialogButton = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(confirmDialogButton);
		
		// TOOLBAR PANE ADD PRE-SET CONTROLS HERE		
		Pane toolbarPane = new Pane();
		VBox toolbarPaneVBox = new VBox();
		
		// SET TOOLBAR STYLES AND POSITIONING		
		toolbarPane.setPrefWidth(1000);
		toolbarPane.setPrefHeight(100);
		toolbarPane.setStyle("-fx-background-color: red");
		toolbarPane.getChildren().add(toolbarPaneVBox);
		
		// INITIALIZE AND ADD CONTROLS TO TOOLBAR PANE
		
		// SHAPE OPTIONS MENU		
		ComboBox<String> shapeOptionsMenu = new ComboBox<String>(); 
		shapeOptionsMenu.getItems().addAll("circle", "rectangle", "line"); 
		shapeOptionsMenu.setPrefWidth(200); 
		shapeOptionsMenu.setPrefWidth(200); 
		
		shapeOptionsMenu.setOnAction((event) -> {
		    int selectedIndex = shapeOptionsMenu.getSelectionModel().getSelectedIndex();
		    Object selectedItem = shapeOptionsMenu.getSelectionModel().getSelectedItem();

		    shapeType = shapeOptionsMenu.getValue();
		    shapeTypeSet = true;
		});
        

	
		toolbarPaneVBox.getChildren().add(shapeOptionsMenu);
		
		// CIRCLE RADIUS SLIDER
		Slider circleRadiusSlider = new Slider(1, 50, 1); 
		circleRadiusSlider.setPrefWidth(200); 
		circleRadiusSlider.setMaxWidth(200); 
		circleRadiusSlider.setShowTickMarks(true); 
		circleRadiusSlider.setMajorTickUnit(1); 
		circleRadiusSlider.setBlockIncrement(1); 		
		circleRadiusSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				circleRadius = arg2.doubleValue();
				circleRadiusSet = true;
        	}
			
    	});
                  
		toolbarPaneVBox.getChildren().add(circleRadiusSlider);
		
		// CIRCLE COLOR PICKER
		ColorPicker colorPicker = new ColorPicker(); 
		EventHandler<ActionEvent>ColorChange = new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Color c = colorPicker.getValue();
				circleColor = c;
				circleColorSet = true;
			}
		};		
		
		colorPicker.setOnAction(ColorChange);
		
		toolbarPaneVBox.getChildren().add(colorPicker);
		
		// ADD TOOLBAR TO ROOT		
		root.getChildren().add(toolbarPane);
		
		// INITIALIZE SCENE AND PASS IN ROOT			
		Scene scene = new Scene(root, 600, 600);
			
		// HANDLE SCENE CLICK		
		scene.setOnMouseClicked(event -> {
			// CHECK IF SHAPE TYPE IS SET			
			if(shapeTypeSet == true) {	
				if(shapeType == "circle") {
					if(circleRadiusSet == true && circleColorSet == true) {
						// DRAW CIRCLE WITH ENTERED PRESETS	
						Circle newCircle = new Circle(event.getX(), event.getY(), circleRadius);
						newCircle.setFill(circleColor);
						root.getChildren().add(newCircle);
						
					}else {
						dialog.setContentText("Please enter a radius and color for your circle");
						dialog.showAndWait();
					}
				}else if(shapeType == "rectangle") {				
					// CHECK IF COLOR, WIDTH, AND HEIGHT IS SET  					
				}else if(shapeType == "line") {
					// CHECK IF COLOR, AND STROKE SIZE IS SET 					
				}
			}else {
				dialog.setContentText("Please Select A Shape Type");
				dialog.showAndWait();
			}
//			double clickedPositionX = event.getX();
//			double clickedPositionY = event.getY();
//			
//			if(!(clickedPositionY <= 115)) {
//				Circle newCircle = new Circle(event.getX(), event.getY(), 15);
//				root.getChildren().add(newCircle);
//			}
		});
		
		mainStage.setScene(scene);
		mainStage.show();
		 
//		StackPane root = new StackPane();
//		Scene scene = new Scene(root, 1000, 1000);
//		
//		Group groupRoot = new Group();
//		Scene sceneBottom = new Scene(groupRoot, 600, 600);
//			
//		sceneBottom.setOnMouseClicked(event -> {
//			Circle newCircle = new Circle(event.getX(), event.getY(), 15);
//			groupRoot.getChildren().add(newCircle);
//		});
//		
//		HBox box = new HBox(); 
//		box.setStyle("-fx-background-color: gray"); 
//		box.setPrefWidth(2000); 
//		box.setMaxWidth(2000); 
//		box.setPrefHeight(200); 
//		box.setMaxHeight(200); 
//		box.setTranslateY(-400); 
//		root.getChildren().add(box);
//		
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
//		box2.getChildren().add(sceneBottom);
//		root.getChildren().add(box2);
//		
//		
//		
//		mainStage.setScene(scene);
//		mainStage.show();
	}
	
}