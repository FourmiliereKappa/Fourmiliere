package drawing;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author duj
 *
 * 
 */
public interface IDrawable {
	/**
	 * @pre: g!=null
	 * @post: configuration de g inchangée
	 */
	public abstract void draw(Graphics g);

	/**
	 * @pre:
	 * @return le rectangle  qui contient complètement this.
	 */
	public abstract Rectangle getBounds();
}