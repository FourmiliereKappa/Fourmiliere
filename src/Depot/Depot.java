package Depot;

import java.util.ArrayList;
import java.util.List;

import drawing.IMovableDrawable;
import monde.Terrain;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;
import suivi.Report;
import suivi.Trace;

public class Depot implements Dessinable, Trace {
	
	int x,y; // coordonnées depot
	List<Cadavre> ListeCadavre; // Stockage des cadavres
	IMovableDrawable skin; // skin du depot
	
	public Depot(int x,int y) {
		
		this.x=x;
		this.y=y;
		ListeCadavre = new ArrayList<Cadavre>();
		Dessineur dessineur = new SkinType1();
	    skin = accept(dessineur); // affectation du skin au depot
	     
	    Terrain.addDessinable(this); // ajout du depot au terrain
	}
	
	public void ajoutCadavre(Cadavre nvCadavre) {
		getListeCadavre().add(nvCadavre); // ajout d'un cadavre
	}


	@Override
	public IMovableDrawable accept(Dessineur dessineur) { // le depot est dessinner
	  return dessineur.dessine(this);
	}

	
	@Override
	public IMovableDrawable getSkin() { // recuperation du skin ( aspect ) du depot
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
	
	public List<Cadavre> getListeCadavre() {
		return ListeCadavre;
	}

	@Override
	public void trace(Report r) {
		for(Cadavre mort : ListeCadavre) {  // trace sur la liste des cadavres afin de get le nombre de cadavres
			mort.trace(r);
		}	
	}
}
