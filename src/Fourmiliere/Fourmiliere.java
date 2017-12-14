package Fourmiliere;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Depot.Depot;
import Fourmi.Fourmi;
import creature.EnnemiSpawner;
import drawing.IMovableDrawable;
import monde.Terrain;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;
import suivi.Report;
import suivi.Trace;

public class Fourmiliere implements Dessinable,Trace{

	List<Fourmi> MesFourmis; // liste des fourmis de la fourmilliere
	private int x; // coordonnées fourmillieres
	private int y;
	private IMovableDrawable skin; // skin de la fourmilliere
	Depot monDepot; // depot de la fourmilliere
	double stocknourriture = 10000; // stock de nourriture présent dans la fourmilliere


	public Fourmiliere(Terrain monTerrain) {

		MesFourmis = new CopyOnWriteArrayList<Fourmi>(); // on utilise un copyonwritearraylist 
		//afin d'eviter les problemes de concurrences

		// ajout du dessinable au terrain après avoir pris son skin
		
		Dessineur dessineur = new SkinType1();
	    skin = accept(dessineur);
	    Terrain.addDessinable(this);

	    // génération aléatoire des coordonnées de la fourmilliere
		x=(int) (Math.random() * 0x75);
		y=(int) (Math.random() * 0x75);

		
		monTerrain.creationFourmiliere(this); // affectation de la fourmilliere au terrain
		
		monTerrain.add(new EnnemiSpawner(x, y));//ajout du spawner d'ennemi aux même coordonnées que la fourmilliere
		// afin d'eviter lesp roblemes de spawn
		
		// creation du depot
		monDepot=new Depot(x+10, y+10);
	}

		
	public void nouvelleFourmi() {
		//création d'une nouvelle fourmis
		Fourmi maFourmis = new Fourmi(this);
		putFourmi(maFourmis);

	}


	// ajout à la liste des fourmis de la fourmilliere
	public void putFourmi(Fourmi manouvelleFourmi) {
		MesFourmis.add(manouvelleFourmi);
	}

	// remove fourmis de la fourmilliere
	public void removeFourmi(Fourmi maFourmieffacer) {
		MesFourmis.remove(maFourmieffacer);
	}

	// lancement du cycle de la fourmilliere
	public void appliqueFourmi() {

		for(Fourmi f: MesFourmis) {
			f.cycle();
		}

	}


	public void setCoX(int x) {
		this.x = x;
	}

	public void setCoY(int y) {
		this.y = y;
	}

	 @Override
	  public IMovableDrawable accept(Dessineur dessineur) {
	    return dessineur.dessine(this);
	  }

	  @Override
	  public IMovableDrawable getSkin() {
	    return skin;
	  }

	  @Override
	  public int getX() {
	    return x;
	  }

	  @Override
	  public int getY() {
	    return y;
	  }

	@Override
	public void trace(Report r) { // lancement des cycles pour chaque fourmis et incrementation du nombre des fourmillieres
		r.traceForFourmiliere(this);
		for (Fourmi fourmi : MesFourmis) {
			fourmi.trace(r);
			fourmi.getetatDev().trace(r);
		}
		monDepot.trace(r);
	}
	
	public Depot getDepot() {
		return monDepot;
	}
	
	public double getstocknourriture() {
		return stocknourriture;
	}
	
	public boolean nourrir(double d) { // méthode pour savoir si on peut nourrir une fourmis ou non
		
		if(stocknourriture-d>0) {
			stocknourriture-=d;	
			return true;
		}
		else {
			return false;
		}
		
	}
}