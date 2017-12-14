package Fourmi.Role;

import java.util.Random;

import Fourmi.EtatDev.Adulte;
import drawing.IMovableDrawable;
import monde.Direction;
import monde.Terrain;
import shapeGiver.Dessineur;
import shapeGiver.Movable;
import shapeGiver.SkinType1;
import suivi.Report;
import suivi.Trace;

public class Ouvriere extends Role implements Movable, Trace{
	
	Adulte RefAdulte;
	int x,y=0;
	IMovableDrawable skin;
	int compteuravantaffectation=50;
	States etat;
	  
	  
	public enum States {
		SUIVRE_PHEROMONES,
		NOURRIR,
		COMBATTRE,
		NETTOYER,
		RETOUR
    }
	
	public Ouvriere(Adulte monAdulte) {
		
		RefAdulte = monAdulte;
		Dessineur dessineur = new SkinType1();
	    skin = accept(dessineur);
		x = getAdulte().getmaFourmi().getLaFourmiliere().getX();
		y = getAdulte().getmaFourmi().getLaFourmiliere().getY();

		etat=States.NOURRIR;
	}
	
    public Adulte getAdulte() {
	    return RefAdulte;
    } 


    @Override
    public IMovableDrawable accept(Dessineur dessineur) {
    	return dessineur.dessine(this);
    }

    @Override
    public IMovableDrawable getSkin() {
    	return skin;
    }

    public void cycle(){
    	
    	if(etat==States.NOURRIR || etat  == States.NETTOYER) {
    		double choixetat = new Random().nextFloat();
    		if(choixetat>=0.5) {
    			Terrain.addDessinable(this);
    			etat=States.SUIVRE_PHEROMONES;
    		}
    		if(choixetat<0.25) {
    			etat=States.NETTOYER;
    		}
    		else {
    			etat=States.NOURRIR;
    		}
    	}
    		
    	
    	if(etat==States.SUIVRE_PHEROMONES)
    		move();
    	
    	if(RefAdulte.getDureevie()+1==RefAdulte.getDureevieMax()) {
    		Terrain.removeDessinable(this);
    		if(etat==States.SUIVRE_PHEROMONES){
    			getAdulte().getmaFourmi().getLaFourmiliere().removeFourmi(getAdulte().getmaFourmi());
    		}
    		else {
    			getAdulte().getmaFourmi().isDead();
    		}
    	}
    }

    public void move(){
	  
    	int direction = (int) (Math.random() * 0x4);

    	switch(direction){
    
    	case 0:
    		Terrain.move(this, Direction.TOP);
    		break;
    	case 1:
    		Terrain.move(this, Direction.LEFT);
    		break;
    	case 2:
    		Terrain.move(this, Direction.DOWN);
    		break;
    	case 3:
    		Terrain.move(this, Direction.RIGHT);
        
    	}
    }

    @Override
    public void setZone(int x,int y){
    	this.x = x;
    	this.y = y;
    }

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void trace(Report r) {
	  r.traceForFourmiliere(this);
	}
	
	public void nonnourris() {
		Terrain.removeDessinable(this);
		if(etat==States.SUIVRE_PHEROMONES){
			getAdulte().getmaFourmi().getLaFourmiliere().removeFourmi(getAdulte().getmaFourmi());
		}
		else {
			getAdulte().getmaFourmi().isDead();
		}
	}
	  
	
}
