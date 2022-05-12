package project; 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class main extends Application {
	public static void main (String [] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		Group group = new Group();
		Scene scene = new Scene(group, 1000,1000);
		Canvas canvasRef = new Canvas(1000, 800);
		
		GraphicsContext graphicContext = canvasRef.getGraphicsContext2D();
		
		String selectedDrawingColor = "";
		
//		graphicContext.setFill(Color.ALICEBLUE);
//		Color color = new Color("0x664db3ff");
		
//		Color newColorObject = Color.decode("#FF0000");
//		graphicContext.setStroke(Color.ALICEBLUE);
			
		
		
		canvasRef.addEventHandler(MouseEvent.MOUSE_PRESSED, 
				new EventHandler<MouseEvent>(){

				@Override
		        public void handle(MouseEvent event) {
					graphicContext.beginPath();
		            graphicContext.moveTo(event.getX(), event.getY());
		            graphicContext.stroke();

		            
				}
	        });

		canvasRef.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
				new EventHandler<MouseEvent>(){

	            @Override
	            public void handle(MouseEvent event) {
	            	graphicContext.lineTo(event.getX(), event.getY());
	                graphicContext.stroke();
	            }
	    });	
		
		canvasRef.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
	        public void handle(MouseEvent event) {
				System.out.println(event.getX());
				String shapeType = "rectangle";
				if(shapeType == "rectangle") {
//					int radius = 20;
//					int circleCenterX = 50;
//					int circleCenterY = 50;
					
//					Circle
				}
	            
			}
        });
		
		HBox box = new HBox();
		box.setStyle("-fx-background-color: black");
		box.setPrefWidth(1000);
		box.setMaxWidth(1000);
		box.setPrefHeight(200);
		box.setMaxHeight(200);
		box.setTranslateY(-400);
		root.getChildren().add(box);
		
		HBox box2 = new HBox();
		box2.setStyle("-fx-background-color: white");
		box2.setPrefWidth(1000);
		box2.setMaxWidth(1000);
		box2.setPrefHeight(2000);
		box2.setMaxHeight(2000);
		box2.setTranslateY(100);
		root.getChildren().add(box2);
		box2.getChildren().add(canvasRef);
		
		ComboBox dropMenu = new ComboBox();
		dropMenu.getItems().addAll("Circle", "Square", "Line");
		dropMenu.setTranslateY(20);
		dropMenu.setPrefWidth(200);
		dropMenu.setPrefWidth(200);
		
		ColorPicker colorPicker = new ColorPicker();
		javafx.scene.paint.Color value = colorPicker.getValue();
		colorPicker.setTranslateY(20);
		colorPicker.setTranslateX(-20);
		
		StackPane.setAlignment(colorPicker, Pos.TOP_RIGHT);
		root.getChildren().add(colorPicker);
		
		StackPane.setAlignment(dropMenu, Pos.TOP_CENTER);
		root.getChildren().addAll(dropMenu);
		
		mainStage.setTitle("Mouse Drawing");
		
		EventHandler<ActionEvent>ColorChange = new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Color c = colorPicker.getValue();
				graphicContext.setStroke(c);
//				graphicContext.setFill(Color.ALICEBLUE);
//				String newColor = colorPicker.getValue().toString();
//				
//				String[] newColorSplit = newColor.split("x", -1);
//				
//				Color newColor = new Color(colorPicker.getValue());
		
				
				
			}
		};
		
		colorPicker.setOnAction(ColorChange);
		
		mainStage.setScene(scene);
		mainStage.show();
		
	}

}