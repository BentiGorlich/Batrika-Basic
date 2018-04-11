package de.BentiGorlich.BatrikaBasic.Mouse;

import de.BentiGorlich.BatrikaBasic.ImageButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class mouseEntered implements EventHandler<MouseEvent> {
	
	ImageButton imgb;
	
	public mouseEntered(ImageButton imageButton) {
		imgb = imageButton;
	}

	@Override
	public void handle(MouseEvent arg0) {
		if(!imgb.getImage().equals(imgb.mouseOver)) {
			imgb.setImage(imgb.mouseOver);
		}
		imgb.mouse = true;
	}

}
