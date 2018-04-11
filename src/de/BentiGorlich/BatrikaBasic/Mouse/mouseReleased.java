package de.BentiGorlich.BatrikaBasic.Mouse;

import de.BentiGorlich.BatrikaBasic.ImageButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class mouseReleased implements EventHandler<MouseEvent>{
	
	ImageButton imgb;
	EventHandler<ActionEvent> action;
	public mouseReleased(ImageButton imgb, EventHandler<ActionEvent> action){
		this.imgb = imgb;
		this.action = action;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		if(!imgb.getImage().equals(imgb.mouseOver)) {
			imgb.setImage(imgb.mouseOver);
		}
		if(imgb.mouse && imgb.click) {
			imgb.click = false;
			ActionEvent ae = new ActionEvent();
			action.handle(ae);
		}
	}

}
