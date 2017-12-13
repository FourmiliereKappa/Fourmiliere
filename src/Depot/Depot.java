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
	
	int x,y;
	List<Cadavre> ListeCadavre;
	IMovableDrawable skin;
	
	public Depot(int x,int y) {
		this.x=x;
		this.y=y;
		ListeCadavre = new ArrayList<Cadavre>();
		Dessineur dessineur = new SkinType1();
	    skin = accept(dessineur);
	    
	    Terrain.addDessinable(this);
	}
	
	public void ajoutCadavre(Cadavre nvCadavre) {
		getListeCadavre().add(nvCadavre);
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
	
	public List<Cadavre> getListeCadavre() {
		return ListeCadavre;
	}

	@Override
	public void trace(Report r) {
		for(Cadavre mort : ListeCadavre) {
			mort.trace(r);
		}
		
	}
}
