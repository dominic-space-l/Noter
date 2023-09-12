package application;

import javafx.scene.Node;

public class dragger {
	//where you click
	private double mouseAnchorX;
	private double mouseAnchorY;
	
	public void nowDraggable(Node node) {
		
		node.setOnMousePressed(event -> {
			//when a click happens, gets stored into mouseAnchorX and Y
			mouseAnchorX = event.getX();
			mouseAnchorY = event.getY();
			
		});
		
		node.setOnMouseDragged(event -> {

			
			
			//setLayout is move the thing
			//getScene is where mouse is in the scene
			//mouseAnchor is starting position of the mouse
			
			//if you remove starting position of the mouse, you can only drag by top left corner
			node.setLayoutX(event.getSceneX() - mouseAnchorX);
			node.setLayoutY(event.getSceneY() - mouseAnchorY);
			
			
			
			//Restricting where the node is within the window/scene
			//Keeping node(s) within bounds, handling each combination/case of node(s) making contact with wall(s)
			
			
			//Left side and its cases
			if(node.getLayoutX() <=23) {
				//left x handling
				if(node.getLayoutY() <=58) {
					//left x then up y handling
					node.setLayoutY(58);
				}
				if((node.getLayoutY() + node.getBoundsInParent().getHeight()) >= 880) {
					//left x then down y handling
					node.setLayoutY(880 - node.getBoundsInParent().getHeight());
				}
				node.setLayoutX(23);
			
				
			//Right side and its cases	
			}else if((node.getLayoutX() + node.getBoundsInParent().getWidth()) >= 1260) {
				//right x handling
				if(node.getLayoutY() <=58) {
					node.setLayoutY(58);
				}
				if((node.getLayoutY() + node.getBoundsInParent().getHeight()) >= 880) {
					//right x then down y handling
					node.setLayoutY(880 - node.getBoundsInParent().getHeight());
				}		
				node.setLayoutX(1260 - node.getBoundsInParent().getWidth());
				
				
				
			//Top side and its cases
			}else if(node.getLayoutY() <=58) {
				//up y handling
				node.setLayoutY(58);
				
					
				
			//Bottom side and its cases	
			}else if((node.getLayoutY() + node.getBoundsInParent().getHeight()) >= 880) {
				//down y handling
				node.setLayoutY(880 - node.getBoundsInParent().getHeight());
				
			}

		});
		

	}
	
}
