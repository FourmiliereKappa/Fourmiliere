package Fourmiliere;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Fourmi;
import drawing.IMovableDrawable;
import monde.Terrain;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;

public class Fourmiliere implements Dessinable{
	
	List<Fourmi> MesFourmis;
	private int x;
	private int y;
	private IMovableDrawable skin;
	
	
	public Fourmiliere(Terrain monTerrain) {
		
		MesFourmis = new CopyOnWriteArrayList<Fourmi>();
		
		Dessineur dessineur = new SkinType1();
	    skin = accept(dessineur);
	    Terrain.addDessinable(this);
		
		x=(int) (Math.random() * 0x150);
		y=(int) (Math.random() * 0x150);
		
		monTerrain.creationFourmiliere(this);
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
}