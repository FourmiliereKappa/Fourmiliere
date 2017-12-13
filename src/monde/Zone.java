package monde;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Role.Ouvriere;
import Fourmiliere.Fourmiliere;
import creature.Ennemi;
import drawing.IMovableDrawable;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;


public class Zone {

	int Pheromone = 0;
	int x,y;
	private List<Dessinable> dessinables;
	private List<Ennemi> ennemis;
	Fourmiliere maFourmilliere=null;


	public Zone(int x,int y) {

		dessinables = new CopyOnWriteArrayList<Dessinable>();
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

	public List<IMovableDrawable> listDraw(){
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


}
