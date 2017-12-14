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

	List<Fourmiliere> lesFourmillieres; // liste des fourmillieres sur le terrain
	List<EnnemiSpawner> ennemiSpawners; // liste des spawners d'ennemis
	static private Hashtable<Integer, Hashtable<Integer, Zone>> zones= new Hashtable<Integer, Hashtable<Integer, Zone>>();
	// toute les zones qu'on a
	static private List<Dessinable> dessinables = new ArrayList<Dessinable>();
	// liste des dessinables


	public Terrain() {

		this.lesFourmillieres = new CopyOnWriteArrayList<Fourmiliere>(); // pour modification concurente
		this.ennemiSpawners = new CopyOnWriteArrayList<EnnemiSpawner>();
		World vue = new World("Monde des fourmis",this); // ajout de la vue
		this.addObserver(vue); // qu'on définie comme observer

		gestionTemps(); // on lance la gestion de temps pour les cycles



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

	public void creationFourmiliere(Fourmiliere maFourmilliere) { // creation des fourmillieres au point donnée
		lesFourmillieres.add(maFourmilliere);
		getZone(maFourmilliere.getX(),maFourmilliere.getY()).setmaFourmilliere(maFourmilliere);
	}

	 public void add(EnnemiSpawner ennemiSpawner) {
	    ennemiSpawners.add(ennemiSpawner);
	}

	public void creaReine() { // ajout d'une nouvelle reine au terrain
		new Reine(this);
	}

	 // changement de zone d'un objet mouvant ( fourmis, ennemis ) en fonction de la direction choisie
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

	 // gestion du temps par thread 
	 public void gestionTemps() {
		 Thread monthread = new Thread() {
				public void run() {
					 while(true) {
				            try {
				                Thread.sleep(50); // Pause // tout les cycles on met 50 millieme de pause
				            } catch (InterruptedException ex) {
				                Thread.currentThread().interrupt();
				                break;
				            }
				            // on lance 20 fois 
				            for(int i = 0; i<20; i++){
				            	
				            	// les cycles des fourmillieres
				            	for(Fourmiliere f: lesFourmillieres) {
				        			f.appliqueFourmi();
				            	}
				            	
				            	// le cycle des ennemispawners
				            	for(EnnemiSpawner ennemiSpawner : ennemiSpawners){
				            		ennemiSpawner.cycle();
				            	}
				            	
				            	// et on reset les dessinables
					            for (Dessinable dessinable : dessinables){
					                dessinable.getSkin().setPosition(new Point(dessinable.getX()+400, dessinable.getY()+300));
					            }
					            
					            // puis on notifie la vue ( l'observer ) des changements
					            setChanged();

					            notifyObservers();
				            }
				        }
				}
			};
			monthread.start();
			
	 }
	 @Override
	public void trace(Report report) {// lancement du trace sur tout les ennemie spawners et toutes les fourmillieres
		report.traceForFourmiliere(this);
		for(Fourmiliere f: lesFourmillieres) {
			f.trace(report);
		}
		for(EnnemiSpawner e: ennemiSpawners) {
			e.trace(report);
		}
		
	}
	
	public ArrayList<Dessinable> getDessinable(){
		return (ArrayList<Dessinable>) dessinables;
	}
	
	public Terrain leTerrain() {
		return this;
	}
	
}

