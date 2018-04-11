package de.BentiGorlich.BatrikaBasic.Mouse;

import de.BentiGorlich.BatrikaBasic.ImageButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class mouseExited implements EventHandler<MouseEvent> {
	
	ImageButton imgb;
	
	public mouseExited(ImageButton imgb) {
		this.imgb = imgb;
	}

	@Override
	public void handle(MouseEvent arg0) {
		if(!imgb.getImage().equals(imgb.normal)) {
			imgb.setImage(imgb.normal);
		}
		imgb.mouse = false;
	}

}
