

package drawing;
import java.awt.*;

public abstract class Morph implements IMovableDrawable {
	
	protected Rectangle bounds;
	protected Color color;
	
	public Morph(Color color, Point pos, Dimension dim){
		this.color=color;
		this.bounds = new Rectangle(dim);
		setPosition(pos);
		
	}
	
	public abstract void draw(Graphics g) ;
	
	public Rectangle getBounds(){
		return (Rectangle) bounds.clone();
	}


	public Point getPosition() {
		Point p=  bounds.getLocation();
		p.x = (p.x+bounds.width/2);
		p.y = (p.y+bounds.width/2);
		return p;
	}

	
	public void setPosition(Point p) {
		bounds.x = (p.x-bounds.width/2);
		bounds.y = (p.y-bounds.height/2);
	}

}
