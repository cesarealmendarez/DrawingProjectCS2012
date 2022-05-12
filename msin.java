package project;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class msin extends Application{
	
	double mouseDownX = 0.0;
	double mouseUpX = 0.0;
	double mouseDownY = 0.0;
	double mouseUpY = 9.0;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		// TODO Auto-generated method stub
		Canvas canvasRef = new Canvas(900, 700);
		StackPane root = new StackPane();
		GraphicsContext graphicContext = canvasRef.getGraphicsContext2D();
	
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

		HBox box = new HBox();
		box.setStyle("-fx-background-color: skyblue");
		box.setPrefWidth(1000);
		box.setMaxWidth(1000);
		box.setPrefHeight(200);
		box.setMaxHeight(200);
		box.setTranslateY(-400);
		root.getChildren().add(box);
		
		VBox vbox1 = new VBox(10);
		
//		hbox1.setStyle("-fx-background-color: skyblue");
//		vbox1.getChildren().add(hbox1);
		
		vbox1.getChildren().add(canvasRef);
		
		Scene scene = new Scene(root);
		
		mainStage.setScene(scene);
		mainStage.show();
		
	}

}
