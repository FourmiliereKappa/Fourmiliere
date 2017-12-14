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

	List<Fourmi> MesFourmis;
	private int x;
	private int y;
	private IMovableDrawable skin;
	Depot monDepot;
	double stocknourriture = 10000;


	public Fourmiliere(Terrain monTerrain) {

		MesFourmis = new CopyOnWriteArrayList<Fourmi>();

		Dessineur dessineur = new SkinType1();
	    skin = accept(dessineur);
	    Terrain.addDessinable(this);

		x=(int) (Math.random() * 0x75);
		y=(int) (Math.random() * 0x75);

		monTerrain.creationFourmiliere(this);
		monTerrain.add(new EnnemiSpawner(x, y));
		
		monDepot=new Depot(x+10, y+10);
	}


	public void nouvelleFourmi() {

		Fourmi maFourmis = new Fourmi(this);
		putFourmi(maFourmis);

	}


	public void putFourmi(Fourmi manouvelleFourmi) {
		MesFourmis.add(manouvelleFourmi);
	}


	public void removeFourmi(Fourmi maFourmieffacer) {
		MesFourmis.remove(maFourmieffacer);
	}

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
	public void trace(Report r) {
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
	
	public boolean nourrir(double d) {
		
		if(stocknourriture-d>0) {
			stocknourriture-=d;	
			return true;
		}
		else {
			return false;
		}
		
	}
}