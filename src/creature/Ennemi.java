package creature;

import drawing.IMovableDrawable;
import monde.Direction;
import monde.Terrain;
import shapeGiver.Dessineur;
import shapeGiver.Movable;
import suivi.Report;
import suivi.Trace;

public abstract class Ennemi implements Movable, Trace {

	protected double poids;
	protected int x;
	protected int y;
	protected IMovableDrawable skin;

	public Ennemi(int x, int y) {
		setZone(x, y);
	}

	@Override
	public IMovableDrawable accept(Dessineur dessineur) { // l'ennemi est dessiner
		return dessineur.dessine(this);
	}

	@Override
	public IMovableDrawable getSkin() { // recupération de la forme sur la map de l'ennemie
		return skin;
	}

	public void cycle() { // En un cycle l'ennemie fait...

	}

	public void setZone(int x, int y) { // définition d'une zone pour l'ennemi
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public double getPoids() {
		return poids;
	}

	public void move() { // mouvement de l'ennemie

		int direction = (int) (Math.random() * 0x4);

		switch (direction) {

		case 0:
			Terrain.move(this, Direction.TOP);
			break;
		case 1:
			Terrain.move(this, Direction.LEFT);
			break;
		case 2:
			Terrain.move(this, Direction.DOWN);
			break;
		case 3:
			Terrain.move(this, Direction.RIGHT);

		}
	}

	@Override
	public void trace(Report r) { // La fonction trace va incrémenter le compteur d'ennemis.
		r.traceForFourmiliere(this);

	}

}
