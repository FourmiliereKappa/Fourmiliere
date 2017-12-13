package monde;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Role.Reine;
import Fourmiliere.Fourmiliere;
import creature.EnnemiSpawner;
import drawing.World;
import shapeGiver.Dessinable;
import shapeGiver.Movable;
import suivi.Report;
import suivi.Trace;

public class Terrain extends Observable implements Trace {

	List<Fourmiliere> lesFourmillieres;
	List<EnnemiSpawner> ennemiSpawners;
	static private Hashtable<Integer, Hashtable<Integer, Zone>> zones= new Hashtable<Integer, Hashtable<Integer, Zone>>();
	static private List<Dessinable> dessinables = new ArrayList<Dessinable>();


	public Terrain() {

		this.lesFourmillieres = new CopyOnWriteArrayList<Fourmiliere>();
		this.ennemiSpawners = new CopyOnWriteArrayList<EnnemiSpawner>();
		World vue = new World("Monde des fourmis",this);
		this.addObserver(vue);

		gestionTemps();



	}

	 public static void addDessinable(Dessinable dessinable){
		    dessinables.add(dessinable);
	 }

	 public static void removeDessinable(Dessinable dessinable){
		    dessinables.remove(dessinable);
	 }

	 public static Zone getZone(int x, int y){

		    if(zones.get(x) == null){
		      zones.put(x, (new Hashtable<Integer, Zone>()));
		    }
		    if(zones.get(x).get(y) == null){
		      zones.get(x).put(y, new Zone(x, y));
		    }
		    return zones.get(x).get(y);
	 }

	public void creationFourmiliere(Fourmiliere maFourmilliere) {
		lesFourmillieres.add(maFourmilliere);
		getZone(maFourmilliere.getX(),maFourmilliere.getY()).setmaFourmilliere(maFourmilliere);
	}

	 public void add(EnnemiSpawner ennemiSpawner) {
	    ennemiSpawners.add(ennemiSpawner);
	}

	public void creaReine() {
		new Reine(this);
	}

	 public static void move(Movable movable, Direction direction){

		    switch (direction){

		      case TOP:
		        getZone(movable.getX(), movable.getY()).remove(movable);
		        movable.setZone(movable.getX(), movable.getY()+1);
		        getZone(movable.getX(), movable.getY()).add(movable);
		        break;
		      case LEFT:
		        getZone(movable.getX(), movable.getY()).remove(movable);
		        movable.setZone(movable.getX()-1, movable.getY());
		        getZone(movable.getX(), movable.getY()).add(movable);
		        break;
		      case DOWN:
		        getZone(movable.getX(), movable.getY()).remove(movable);
		        movable.setZone(movable.getX(), movable.getY()-1);
		        getZone(movable.getX(), movable.getY()).add(movable);
		        break;
		      case RIGHT:
		    	getZone(movable.getX(), movable.getY()).remove(movable);
		        movable.setZone(movable.getX()+1, movable.getY());
		        getZone(movable.getX(), movable.getY()).add(movable);
		        break;
		    }
	 }


	 public void gestionTemps() {
		 Thread monthread = new Thread() {
				public void run() {
					 while(true) {
				            try {
				                Thread.sleep(50); // Pause
				            } catch (InterruptedException ex) {
				                Thread.currentThread().interrupt();
				                break;
				            }
				            for(int i = 0; i<20; i++){

				            	for(Fourmiliere f: lesFourmillieres) {
				        			f.appliqueFourmi();
				            	}

				            	for(EnnemiSpawner ennemiSpawner : ennemiSpawners){
				            		ennemiSpawner.cycle();
				            	}
				            	
					            for (Dessinable dessinable : dessinables){
					                dessinable.getSkin().setPosition(new Point(dessinable.getX()+400, dessinable.getY()+300));
					            }
					            
					            setChanged();

					            notifyObservers();
				            }
				        }
				}
			};
			monthread.start();
			
	 }
	 @Override
	public void trace(Report report) {
		report.traceForFourmiliere(this);
		for(Fourmiliere f: lesFourmillieres) {
			f.trace(report);
		}
		
	}
	
	public ArrayList<Dessinable> getDessinable(){
		return (ArrayList<Dessinable>) dessinables;
	}
	
	public Terrain leTerrain() {
		return this;
	}
	
}

