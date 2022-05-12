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
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FinalMain extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}


	@Override
	public void start(Stage mainStage) throws Exception {
		boolean isbutton = true;

		mainStage.setTitle("creating circle");
 
//        Circle circle = new Circle(0.0f, 0.0f, 5.f);
		Circle circle = new Circle();
		circle.setLayoutX(0);
		circle.setLayoutY(0);
		circle.setRadius(15.0);
//        circle.setCenterX(0);
//        circle.setCenterY(0);
//        circle.setRadius(15.0);
//        circle.setTranslateX(-100);
        
        StackPane pane = new StackPane();
        pane.setStyle("-fx-background-color: red");
        
        
        Rectangle rectangle = new Rectangle(100.0d, 100.0d, 120.0d, 80.0d);
        
        Rectangle secondRectangle = new Rectangle(200.0d, 200.0d, 120.0d, 80.0d);
        
        Group group = new Group();
        
        pane.getChildren().add(circle);
        group.getChildren().add(secondRectangle);
        group.getChildren().add(rectangle);
        
        Scene scene = new Scene(pane, 500, 300);
        
        Button button = new Button("UNDO");
        
		EventHandler<ActionEvent>buttonAction = new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				group.getChildren().remove(group.getChildren().size() - 2);
//				System.out.print(arg0.get)
			}
		};
		
        button.setOnAction(buttonAction);
        	
        group.getChildren().add(button);
        
        mainStage.setScene(scene);	
  
		mainStage.show();
		
	}

}
