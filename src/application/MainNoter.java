package application;
import java.util.Random;

	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class MainNoter extends Application {

	public static Stage primaryStage;
	public static AnchorPane anchPane;
	@Override
	 public void start(Stage stage) throws IOException {
		
       //Parent root = FXMLLoader.load(getClass().getResource("Noterfxml.fxml"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Noterfxml.fxml"));
		AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        
        primaryStage = stage;
        
       
       //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
       String css = this.getClass().getResource("application.css").toExternalForm();
       scene.getStylesheets().add(css);
       
       //make button to create a sticky note aka anchorpane with shit on it
       //*****check out other "setOn" methods for buttons and other nodes*****
       

       Button create = new Button("Add Note");
       create.setLayoutX(100);
       create.setLayoutY(100);
       create.setOnAction(event -> {
    	  TextField textField = new TextField();
    	  textField.getStyleClass().add("textField");
    	  textField.setPrefWidth(145.0);
    	  AnchorPane anch = new AnchorPane();
    	  anch.setPrefHeight(145.0);
    	  anch.setPrefWidth(145.0);
    	  anch.getStyleClass().add("anch");
    	  anchPane = anch;
    	  
    	  

    	  
    	  anch.setLayoutX(300);
    	  anch.setLayoutY(300);
    	  
    	  //The static method setTopAnchor(Node, Double) from the type AnchorPane should be accessed in a static way
    	  //static: belongs to class rather than instance of class
    	  //static method, don't have to create instance of class
    	  //"anch" is an instance, use AnchorPane to change access to static
    	  //instead of anch.setTopAnchor(textField, 10.0);
    	  AnchorPane.setTopAnchor(textField, 0.0);
    	  
    	  
    	  anch.getChildren().add(textField);
    	   
          dragger d = new dragger();
          d.nowDraggable(anch);
    	  root.getChildren().add(anch);
    	  
       });
       
       
       root.getChildren().add(create);
       
       
       
       stage.setScene(scene);

       //use stage style to style shit out of the scene!!!!!!
       stage.initStyle(StageStyle.UTILITY);
       stage.initStyle(StageStyle.TRANSPARENT);
       //^^^^^^^^^ use to style the bar to drag the window,
       
       stage.resizableProperty().setValue(false);

       stage.show();


	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
