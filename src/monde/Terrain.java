package monde;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Role.Reine;
import Fourmiliere.Fourmiliere;
import drawing.World;
import shapeGiver.Dessinable;
import shapeGiver.Movable;

public class Terrain {
	
	List<Fourmiliere> lesFourmillieres;
	List<Ennemie> lesEnnemies;
	static private Hashtable<Integer, Hashtable<Integer, Zone>> zones= new Hashtable<Integer, Hashtable<Integer, Zone>>();
	static private List<Dessinable> dessinables = new ArrayList<Dessinable>();
	static World leworld;
	
	  
	public Terrain(World leworld) {
		
		this.lesFourmillieres = new CopyOnWriteArrayList<Fourmiliere>();
		this.lesEnnemies = new CopyOnWriteArrayList<Ennemie>();
		
		
		Thread monthread = new Thread() {
			public void run() {
				 while(true) {
			            try {
			                Thread.sleep(50); // Pause 
			            } catch (InterruptedException ex) {
			                Thread.currentThread().interrupt(); 
			                break; 
			            }
			            for(int i=0;i<20;i++) {
			            	for(Fourmiliere f: lesFourmillieres) {
			        			f.appliqueFourmi();
			        		}
			            }
			            for (Dessinable dessinable : dessinables){
			                dessinable.getSkin().setPosition(new Point(dessinable.getX()+400, dessinable.getY()+300));
			            }
			            leworld.repaint();
			        }
			}
		};
		monthread.start();
		
		Terrain.leworld=leworld;
		
		
	}
	
	 public static void addDessinable(Dessinable dessinable){
		 	leworld.add(dessinable.getSkin());
		    dessinables.add(dessinable);
	 }

	 public static void removeDessinable(Dessinable dessinable){
		 	leworld.remove(dessinable.getSkin());
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
		getZone(maFourmilliere.getCoX(),maFourmilliere.getCoY()).setmaFourmilliere(maFourmilliere);
		
	}
	
	public void creaReine() {
		new Reine(this);
	}
	
	 public static void move(Movable movable, Direction direction){
		 
		    switch (direction){
		    
		      case TOP:
		        movable.setZone(movable.getX(), movable.getY()-1);
		        getZone(movable.getX(), movable.getY()+1).removeDessinable(movable);
		        break;
		      case LEFT:
		        movable.setZone(movable.getX()-1, movable.getY());
		        getZone(movable.getX()+1, movable.getY()).removeDessinable(movable);
		        break;
		      case DOWN:
		        movable.setZone(movable.getX(), movable.getY()+1);
		        getZone(movable.getX(), movable.getY()-1).removeDessinable(movable);
		        break;
		      case RIGHT:
		        movable.setZone(movable.getX()+1, movable.getY());
		        getZone(movable.getX()-1, movable.getY()).removeDessinable(movable);
		        break;
		        
		    }

	 }
}

