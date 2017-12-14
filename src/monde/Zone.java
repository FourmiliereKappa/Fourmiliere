package monde;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmiliere.Fourmiliere;
import creature.Ennemi;
import shapeGiver.Dessinable;


public class Zone {

	int Pheromone = 0; // nombre de phéromones
	int x,y; // coordonnée de la zone
	private List<Dessinable> dessinables; // liste des dessinables présents dans la fourmilliere
	private List<Ennemi> ennemis; // on differencie avec les ennemies
	Fourmiliere maFourmilliere; // possibilitée d'avoir une fourmilliere dans la case 


	public Zone(int x,int y) {

		dessinables = new CopyOnWriteArrayList<Dessinable>(); // modification dynamique possible -> gestion concurence
		ennemis = new CopyOnWriteArrayList<Ennemi>();
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

	public void remove(Dessinable monDessinable) {
		dessinables.remove(monDessinable);
	}

	public void add(Dessinable monDessinable) {
		dessinables.add(monDessinable);
	}

	public void add(Ennemi ennemi) {
		ennemis.add(ennemi);
	}

	public void remove(Ennemi insecte) {
	 ennemis.remove(insecte);
	}

	public void setmaFourmilliere(Fourmiliere maFourmilliere) { // méthode ajout fourmilliere dans zone

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
	
	// en prévision d'évolution 
	/**
	 * 
	 * public List<IMovableDrawable> listDraw(){
	  List<IMovableDrawable> r = new ArrayList<IMovableDrawable>();
	  Dessineur dessineur = new SkinType1();

	   if(!ennemis.isEmpty()){
	    r.add(dessineur.dessine(ennemis.get(0)));

	    if(!dessinables.isEmpty()){
	      r.add(dessineur.dessine(((Ouvriere)dessinables.get(0)), dessinables.size()));
	    }
	  }
	  else if(!dessinables.isEmpty()){
	    r.add(dessineur.dessine((Ouvriere)dessinables.get(0)));
	  }

	  return r;
	}

   **/
}
