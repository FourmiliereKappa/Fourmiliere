package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Morph {

	public Oval(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
		
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(bounds.x,bounds.y,bounds.height,bounds.width);
		g.setColor(c);
	}

}
