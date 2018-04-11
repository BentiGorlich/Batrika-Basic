package de.BentiGorlich.BatrikaBasic.Mouse;

import de.BentiGorlich.BatrikaBasic.ImageButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class mouseClicked implements EventHandler<MouseEvent> {
	ImageButton imgb;
	public mouseClicked(ImageButton imgb){
		this.imgb = imgb;
	}
	@Override
	public void handle(MouseEvent arg0) {
		if(arg0.getButton().equals(MouseButton.PRIMARY)) {
			if(!imgb.getImage().equals(imgb.clicked)) {
				imgb.setImage(imgb.clicked);
			}
			imgb.click = true;
		}
	}

}
