
package drawing.demos;

import java.awt.Color;
import java.awt.Dimension;
import drawing.World;
import monde.theWorld;

public class Demo3 {


	public static void main(String[] args) {
		World jc = new World("Un essai de Morphs");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));
		theWorld.setWorld(jc);

		//new Fourmi();

		jc.open();

		while (true) {
		  theWorld.cycle();

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jc.repaint();
		}
	}

}
