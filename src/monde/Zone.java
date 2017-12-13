package monde;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmiliere.Fourmiliere;
import creature.Ennemie;
import shapeGiver.Dessinable;

public class Zone {
	
	int Pheromone = 0;
	int x,y;
	private List<Dessinable> dessinables; 
	Ennemie monEnnemis=null;
	Fourmiliere maFourmilliere=null;
	
	
	public Zone(int x,int y) {
		
		dessinables = new CopyOnWriteArrayList<Dessinable>();
		this.x=x;
		this.y=y;
		
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void removeDessinable(Dessinable monDessinable) {
		dessinables.remove(monDessinable);
	}
	
	public void addDessinable(Dessinable monDessinable) {
		Pheromone+=25;
		dessinables.add(monDessinable);
	}
	
	public void setEnnemis(Ennemie monEnnemie) {
		monEnnemis=monEnnemie;
	}
	
	public void setmaFourmilliere(Fourmiliere maFourmilliere) {
		
		System.out.println("Fourmiliere ajoutée aux cooordonnées :" + this.x + "," + this.y);
		this.maFourmilliere=maFourmilliere;
		System.out.println(maFourmilliere.getX() + " , " + maFourmilliere.getY());
		
	}
	
	public int getPheromone() {
		return Pheromone;
	}
	
	public void retirerPheromone() {
		System.out.println(Pheromone);
		Pheromone -= 1;
	}
	
	
}
