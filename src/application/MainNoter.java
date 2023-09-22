package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



public class MainNoter extends Application {
	
	//change to private with getters, later
	public static Stage primaryStage;
	public static AnchorPane anchPane;
	public static Button noterExit;
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
    	   
    	   Button noterClose = new Button("x");

    	   noterClose.getStyleClass().add("noterClose");

    	   
    	   
    	   
    	   TextField textField = new TextField();
    	   textField.getStyleClass().add("textField");
    	   AnchorPane anch = new AnchorPane();
     	   AnchorPane.setTopAnchor(textField, 32.0);
     	   AnchorPane.setRightAnchor(textField, 5.0);
     	   
     	   
     	   TextField timeField = new TextField();
     	   timeField.getStyleClass().add("timeField");
     	   AnchorPane.setBottomAnchor(timeField, 3.0);
     	   AnchorPane.setRightAnchor(timeField, 53.0);
     	   
     	   
     	   Button timePreference = new Button("min(s)");
     	   timePreference.getStyleClass().add("timePreference");
     	   AnchorPane.setBottomAnchor(timePreference, 2.0);
    	   AnchorPane.setRightAnchor(timePreference, 2.0);
     	   


    	   anch.getStyleClass().add("anch");
    	   anchPane = anch;
    	  
    	  

    	  
    	  anch.setLayoutX(300);
    	  anch.setLayoutY(300);
    	  
    	  //The static method setTopAnchor(Node, Double) from the type AnchorPane should be accessed in a static way
    	  //static: belongs to class rather than instance of class
    	  //static method, don't have to create instance of class
    	  //"anch" is an instance, use AnchorPane to change access to static
    	  //instead of anch.setTopAnchor(textField, 10.0);

    	  
    	  
    	  anch.getChildren().add(textField);
    	  anch.getChildren().add(timeField);
    	  anch.getChildren().add(timePreference);
    	  anch.getChildren().add(noterClose);

    	   
          dragger d = new dragger();
          d.nowDraggable(anch);
    	  root.getChildren().add(anch);

    	  
    	 //note exit listener
  		noterClose.setOnMouseClicked(event2 -> {
			root.getChildren().remove(anch);
		});
  		
  		timePreference.setOnMouseClicked(event3 -> {
  			if(timePreference.getText().equals("hr(s)")) {
  				timePreference.setText("min(s)");
  	     	    AnchorPane.setRightAnchor(timeField, 53.0);
  			}else {
  				timePreference.setText("hr(s)");
  	     	    AnchorPane.setRightAnchor(timeField, 44.0);
  			}
  		});
    	  
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
