package de.BentiGorlich.BatrikaBasic;

import de.BentiGorlich.BatrikaBasic.Mouse.mouseClicked;
import de.BentiGorlich.BatrikaBasic.Mouse.mouseEntered;
import de.BentiGorlich.BatrikaBasic.Mouse.mouseExited;
import de.BentiGorlich.BatrikaBasic.Mouse.mouseReleased;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageButton extends ImageView{
	
	public Image normal;
	public Image mouseOver;
	public Image clicked;
	
	public boolean mouse = false;
	public boolean click = false;
	
	public ImageButton(Image normal, Image MouseOver, Image clicked, EventHandler<ActionEvent> onAction, double height, double width){
		this.normal = normal;
		this.mouseOver = MouseOver;
		this.clicked = clicked;
		this.setImage(normal);
		this.setFitHeight(height);
		this.setFitWidth(width);
		onMouseEnteredProperty().set(new mouseEntered(this));
		onMouseExitedProperty().set(new mouseExited(this));
		onMousePressedProperty().set(new mouseClicked(this));
		onMouseReleasedProperty().set(new mouseReleased(this, onAction));
	}
	
	public void setToolTip(String tooltip) {
		Tooltip temp = new Tooltip(tooltip);
		Tooltip.install(this, temp);
	}
}