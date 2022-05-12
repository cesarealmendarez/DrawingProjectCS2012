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
import javafx.scene.shape.Rectangle;
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
	
	double rectangleWidth = 0.0;
	boolean rectangleWidthSet = false;
	double rectangleHeight = 0.0;
	boolean rectangleHeightSet = false;
	Color rectangleColor = Color.WHITE;
	boolean rectangleColorSet = false;
	
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
		// SHAPE OPTIONS MENU		
		ComboBox<String> shapeOptionsMenu = new ComboBox<String>(); 
		shapeOptionsMenu.getItems().addAll("circle", "rectangle", "line"); 
		shapeOptionsMenu.setPrefWidth(200); 
		shapeOptionsMenu.setPrefWidth(200); 

//		shapeOptionsMenu.setOnAction((event) -> {
//		    int selectedIndex = shapeOptionsMenu.getSelectionModel().getSelectedIndex();
//		    Object selectedItem = shapeOptionsMenu.getSelectionModel().getSelectedItem();
//
//		    shapeType = shapeOptionsMenu.getValue();
//		    shapeTypeSet = true;
//		});
        

		toolbarPaneVBox.getChildren().add(shapeOptionsMenu);		
		
		HBox toolbarPaneHbox = new HBox();
			
		toolbarPaneVBox.getChildren().add(toolbarPaneHbox);
		
		VBox toolbarPaneCircleVbox = new VBox();
		VBox toolbarPaneRectangleVbox = new VBox();
		VBox toolbarPaneLineVbox = new VBox();
		
		toolbarPaneHbox.getChildren().add(toolbarPaneCircleVbox);
		toolbarPaneCircleVbox.setVisible(false);
		toolbarPaneHbox.getChildren().add(toolbarPaneRectangleVbox);
		toolbarPaneRectangleVbox.setVisible(false);
		toolbarPaneHbox.getChildren().add(toolbarPaneLineVbox);
		toolbarPaneLineVbox.setVisible(false);
		
		// UNDO BUTTON
		Button undoButton = new Button("UNDO");
		
		EventHandler<ActionEvent>undoButtonAction = new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println(root.getChildren().size() - 1);
				root.getChildren().remove(root.getChildren().size() - 1);
//				System.out.print(arg0.get)
			}
		};
		
		undoButton.setOnAction(undoButtonAction);
        	
        toolbarPaneLineVbox.getChildren().add(undoButton);
		
		// SET TOOLBAR STYLES AND POSITIONING		
		toolbarPane.setPrefWidth(1000);
		toolbarPane.setPrefHeight(100);
		toolbarPane.setStyle("-fx-background-color: red");
		toolbarPane.getChildren().add(toolbarPaneVBox);
		
		// INITIALIZE AND ADD CONTROLS TO TOOLBAR PANE
		
		
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
                  
		toolbarPaneCircleVbox.getChildren().add(circleRadiusSlider);
		
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
		
		toolbarPaneCircleVbox.getChildren().add(colorPicker);
		
		// RECTANGLE PRESETS
			
		// RECTANGLE WIDTH INPUT
		TextField rectangleWidthInput = new TextField("");
		
        EventHandler<ActionEvent> rectangleWidthInputChange = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
            	rectangleWidth = Double.parseDouble(rectangleWidthInput.getText());
            	rectangleWidthSet = true;
            }
        };
  
        rectangleWidthInput.setOnAction(rectangleWidthInputChange);	
        toolbarPaneRectangleVbox.getChildren().add(rectangleWidthInput);
		
		// RECTANGLE HEIGHT INPUT
		TextField rectangleHeightInput = new TextField("");
		
        EventHandler<ActionEvent> rectangleHeightInputChange = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
            	rectangleHeight = Double.parseDouble(rectangleHeightInput.getText());
            	rectangleHeightSet = true;
            }
        };
  
        rectangleHeightInput.setOnAction(rectangleHeightInputChange);	
        toolbarPaneRectangleVbox.getChildren().add(rectangleHeightInput);        
		
		// RECTANGLE COLOR PICKER
		ColorPicker rectangleColorPicker = new ColorPicker(); 
		EventHandler<ActionEvent>RectangleColorChange = new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Color c = rectangleColorPicker.getValue();
				rectangleColor = c;
				rectangleColorSet = true;
			}
		};		
		
		rectangleColorPicker.setOnAction(RectangleColorChange);
		
		toolbarPaneRectangleVbox.getChildren().add(rectangleColorPicker);		
		
		// ADD TOOLBAR TO ROOT		
		root.getChildren().add(toolbarPane);
		
		// INITIALIZE SCENE AND PASS IN ROOT			
		Scene scene = new Scene(root, 600, 600);
			
		// HANDLE SCENE CLICK		
		scene.setOnMouseClicked(event -> {
			// CHECK IF MOUSE CLICK POSITION IS NOT ON TOOLBAR
			if(event.getY() >= 125) {
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
						if(rectangleWidthSet == true && rectangleHeightSet == true && rectangleColorSet == true) {
							Rectangle rectangle = new Rectangle(event.getX(), event.getY(), rectangleWidth, rectangleHeight);
							rectangle.setFill(rectangleColor);
							root.getChildren().add(rectangle);
						}else {
							dialog.setContentText("Please enter a width, height, and color for your rectangle");
							dialog.showAndWait();
						}					
					}else if(shapeType == "line") {
						// CHECK IF COLOR, AND STROKE SIZE IS SET 					
					}
				}else {
					dialog.setContentText("Please Select A Shape Type");
					dialog.showAndWait();
				}
			}
		});
		
		EventHandler<ActionEvent> shapeOptionsMenuChange = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (shapeOptionsMenu.getValue() == "circle") {
					shapeType = "circle";
					shapeTypeSet = true;
					toolbarPaneRectangleVbox.setVisible(false);
					toolbarPaneLineVbox.setVisible(false);
					toolbarPaneCircleVbox.setVisible(true);
//					rectangleHeightInput.setVisible(false);
//					rectangleWidthInput.setVisible(false);
//					circleRadiusSlider.setVisible(true);
////					submitInfo.setVisible(false);
//					colorPicker.setVisible(true);
					rectangleColorPicker.setVisible(false);
				} else if (shapeOptionsMenu.getValue() == "rectangle") {
					shapeType = "rectangle";
					shapeTypeSet = true;
					toolbarPaneCircleVbox.setVisible(false);
					toolbarPaneLineVbox.setVisible(false);
					toolbarPaneRectangleVbox.setVisible(true);
//					rectangleHeightInput.setVisible(true);
//					rectangleHeightInput.setText("Choose height");
//					rectangleHeightInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 5));
//					rectangleWidthInput.setText("Choose width");
//					rectangleWidthInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 5));
//					rectangleWidthInput.setVisible(true);
////					submitInfo.setVisible(true);
//					rectangleColorPicker.setVisible(true);

				} else if (shapeOptionsMenu.getValue() == "line"){
					shapeType = "line";
					shapeTypeSet = true;
					toolbarPaneCircleVbox.setVisible(false);
					toolbarPaneRectangleVbox.setVisible(false);
					toolbarPaneLineVbox.setVisible(true);
//					rectangleHeightInput.setVisible(false);
//					rectangleWidthInput.setVisible(false);
//					circleRadiusSlider.setVisible(false);
////					submitInfo.setVisible(false);
//					rectangleColorPicker.setVisible(false);
//					circleRadiusSlider.setVisible(false);

				}
				// TODO Auto-generated method stub

			}

		};
		
		shapeOptionsMenu.setOnAction(shapeOptionsMenuChange);		
		
		mainStage.setScene(scene);
		mainStage.show();
		 
	}
	
}