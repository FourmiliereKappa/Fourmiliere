package TestFourmiliere;

import Fourmi.Role.Reine;
import drawing.World;
import monde.Terrain;

public class test {

	public static void main(String[] args) {
		
		World monWorld = new World("tata");
		Terrain leterrain = new Terrain(monWorld);
		new Reine(leterrain);
	}
}
