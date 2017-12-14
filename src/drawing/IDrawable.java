package drawing;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface IDrawable {

	public abstract void draw(Graphics g);

	public abstract Rectangle getBounds();
	
}