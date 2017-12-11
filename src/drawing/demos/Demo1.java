
package drawing.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import drawing.Oval;
import drawing.IMovableDrawable;
import drawing.World;

public class Demo1 {

	public static void main(String[] args) {
		Random x = new Random();
		World jc = new World("Un essai de Morphs");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));
		Dimension dim = new Dimension(5, 5);
		for (int i = 0; i < 10000; i++) {
			dim = new Dimension(x.nextInt(20), x.nextInt(20));
			jc.add(new Oval(new Color(0), new Point(0, 0), dim));
		}
		jc.open();
		while (true) {
			List<IMovableDrawable> drawables = jc.contents();
			for (Iterator<IMovableDrawable> iter = drawables.iterator(); iter.hasNext();) {
				iter.next().setPosition(new Point(x.nextInt(800), x.nextInt(600)));
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jc.repaint();
		}
	}

}
