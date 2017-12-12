
package drawing.demos;

import java.awt.Color;
import java.awt.Dimension;
import drawing.World;
import monde.Terrain;

public class Demo3 {


	public static void main(String[] args) {
		World jc = new World("ok");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));
		

		jc.open();

		Terrain monTerrain = new Terrain(jc);
		monTerrain.creaReine();
	}

}
