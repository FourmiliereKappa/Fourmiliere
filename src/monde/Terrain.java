package monde;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Role.Reine;
import Fourmiliere.Fourmiliere;
import creature.EnnemiSpawner;
import drawing.World;
import shapeGiver.Dessinable;
import shapeGiver.Movable;
import suivi.Report;
import suivi.Trace;
import Parametre.Parametre;

public class Terrain implements Trace {

	List<Fourmiliere> lesFourmillieres;
	List<Ennemie> lesEnnemies;
	static private Hashtable<Integer, Hashtable<Integer, Zone>> zones = new Hashtable<Integer, Hashtable<Integer, Zone>>();
	static private List<Dessinable> dessinables = new ArrayList<Dessinable>();
	static World leworld;

	public Terrain(World leworld) {

		this.lesFourmillieres = new CopyOnWriteArrayList<Fourmiliere>();
		this.lesEnnemies = new CopyOnWriteArrayList<Ennemie>();
		Terrain.leworld = leworld;

		gestionTemps();

	}

	public static void addDessinable(Dessinable dessinable) {
		leworld.add(dessinable.getSkin());
		dessinables.add(dessinable);
	}

	public static void removeDessinable(Dessinable dessinable) {
		leworld.remove(dessinable.getSkin());
		dessinables.remove(dessinable);
	}

	public static Zone getZone(int x, int y) {

		if (zones.get(x) == null) {
			zones.put(x, (new Hashtable<Integer, Zone>()));
		}
		if (zones.get(x).get(y) == null) {
			zones.get(x).put(y, new Zone(x, y));
		}
		return zones.get(x).get(y);
	}

	public void creationFourmiliere(Fourmiliere maFourmilliere) {

		lesFourmillieres.add(maFourmilliere);
		getZone(maFourmilliere.getX(), maFourmilliere.getY()).setmaFourmilliere(maFourmilliere);

	}

	public void creaReine() {
		new Reine(this);
	}

	public static void move(Movable movable, Direction direction) {

		switch (direction) {

		case TOP:
			getZone(movable.getX(), movable.getY()).removeDessinable(movable);
			movable.setZone(movable.getX(), movable.getY() + 1);
			getZone(movable.getX(), movable.getY()).addDessinable(movable);
			break;
		case LEFT:
			getZone(movable.getX(), movable.getY()).removeDessinable(movable);
			movable.setZone(movable.getX() - 1, movable.getY());
			getZone(movable.getX(), movable.getY()).addDessinable(movable);
			break;
		case DOWN:
			getZone(movable.getX(), movable.getY()).removeDessinable(movable);
			movable.setZone(movable.getX(), movable.getY() - 1);
			getZone(movable.getX(), movable.getY()).addDessinable(movable);
			break;
		case RIGHT:
			getZone(movable.getX(), movable.getY()).removeDessinable(movable);
			movable.setZone(movable.getX() + 1, movable.getY());
			getZone(movable.getX(), movable.getY()).addDessinable(movable);
			break;

		}

	}
//
	@Override
	public void trace(Report r) {
		System.out.println(lesFourmillieres.size());
		r.traceForFourmiliere(this);
		for (Fourmiliere f : lesFourmillieres) {
			System.out.println("test");
			f.trace(r);
		}
	}

	public void gestionTemps() {
		Thread monthread = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000 / Parametre.FPS); // Pause
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
						break;
					}
					for (int i = 0; i < 20; i++) {

						for (Fourmiliere f : lesFourmillieres) {
							f.appliqueFourmi();
						}

					}

					for (Dessinable dessinable : dessinables) {
						dessinable.getSkin().setPosition(new Point(dessinable.getX() + 400, dessinable.getY() + 300));
					}
					leworld.repaint();
				}
			}
		};
		monthread.start();
	}

	public World getWorld() {
		return leworld;
	}
}
