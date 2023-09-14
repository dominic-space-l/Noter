package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class Controller implements Initializable{
	Stage stage;
	@FXML
	private AnchorPane topBar;
	@FXML
	private Button exit;
	private double x;
	private double y;
	@FXML
	private Button show;

	
	//******
	//
	//
	//
	//in the scene, for loop get(index) all the nodes, if they are within a certain x coordinate, add up the time(on the sticky note)
	//
	//
	//
	//******
	
	public void showAnch(ActionEvent event){
		try {
			System.out.println("height: " + MainNoter.anchPane.getHeight());
			System.out.println("width: " + MainNoter.anchPane.getWidth());
			System.out.println("x position " + MainNoter.anchPane.getLayoutX());
			System.out.println("y position " + MainNoter.anchPane.getLayoutY());


			try {
			TextField retrievedTextField = (TextField) MainNoter.anchPane.getChildren().get(0);


			if(retrievedTextField.getText().isEmpty()) {
				return;
				}else {
					retrievedTextField.setText("yoooo");
				}
			}catch(Exception e) {
				System.out.println("the textfield is empty");
			}
		}catch(RuntimeException e){
			System.out.println("anch does not exist yet");
		}
		
	}

	public void exit(ActionEvent event) throws IOException{
		Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
		stage.close();
		
	}
	dragger d = new dragger();

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		topBar.setOnMousePressed(event -> {
			x = event.getSceneX();
			y = event.getSceneY();
			
		});
		
		topBar.setOnMouseDragged(event ->{
			MainNoter.primaryStage.setX(event.getScreenX() - x);
			MainNoter.primaryStage.setY(event.getScreenY() - y);
		});
		
		
		
		

		

		
	}
	

	
}
