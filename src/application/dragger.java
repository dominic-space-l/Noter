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
			node.toFront();
			
			
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

		//sectional handling
		node.setOnMouseReleased(event ->{
			
			//left pillar handling (minus 1 exception)
			//if staying side is within panel AND the other side is out of panel
			if((node.getLayoutX() < 420) && (node.getLayoutX() + 150) > 416) {
				//from left, if more than half is over, put middle
				//from middle, if less than half is over, return
				if((node.getLayoutX() + 75) > 430) {
					node.setLayoutX(444);
				//from left, if less than half is over, return
				}else if((node.getLayoutX() + 75) < 430) {
					node.setLayoutX(416-150);
				}
			}
			
			//right pillar handling (minus 1 exception)
			//if staying side is within panel AND the other side is out of panel
			if(((node.getLayoutX() + 150) > 864) && (node.getLayoutX() < 864)) {
				//from left, if more than half is over, put middle
				//from middle, if less than half is over, return
				if((node.getLayoutX() + 75 < 850)) {
					node.setLayoutX(836-150);
				}else if((node.getLayoutX() + 75) > 850){
					node.setLayoutX(864);
		}
			}
			//handling the 2 aforementioned exceptions 
			
			//if left side of note (currently in the middle) that is going out of bounds is between (420 <= x < 444 ), return it back to middle
			//(<= and not < because small area exists where it doesn't return)
			if((420 <= node.getLayoutX()) && (node.getLayoutX() < 444)) {
				node.setLayoutX(444);
			}
			//if right side of note (currently in the middle) that is going out of bounds is between (836 < x < 865), return it back to middle 
			//(since 860 is the x position of the right side of the right pillar, changed bound to 865 to compensate for the shadow)
			if((836 < (node.getLayoutX() + 150)) && ((node.getLayoutX() + 150) < 865)) {
				node.setLayoutX(836-150);
			}

		});

	}
	
}
