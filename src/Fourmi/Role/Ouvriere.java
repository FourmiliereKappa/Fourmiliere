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
	
	Adulte RefAdulte; // référence vers l'adulte 
	int x,y=0; // coordonnées de la fourmis
	IMovableDrawable skin;  // skin de l'ouvriere
	int compteuravantaffectation=50; // compteur avant changement de tache
	States etat; // tache actuelle
	  
	  
	public enum States { // les différentes taches possibles d'une ouvriere
		SUIVRE_PHEROMONES,
		NOURRIR,
		COMBATTRE,
		NETTOYER,
		RETOUR
    }
	
	public Ouvriere(Adulte monAdulte) {
		
		RefAdulte = monAdulte;
		Dessineur dessineur = new SkinType1(); 
	    skin = accept(dessineur); // définition du skin de la fourmis
		x = getAdulte().getmaFourmi().getLaFourmiliere().getX(); // les coordonnées de base sont aux coordonnées de la fourmilliere
		y = getAdulte().getmaFourmi().getLaFourmiliere().getY();

		etat=States.NOURRIR; // l'etat de base est celui de nourrir la fourmilliere
	}
	
    public Adulte getAdulte() {
	    return RefAdulte;
    } 


    @Override
    public IMovableDrawable accept(Dessineur dessineur) {
    	return dessineur.dessine(this);// prend le dessin de la fourmis
    }

    @Override
    public IMovableDrawable getSkin() {
    	return skin;
    }

    public void cycle(){
    	

    	// si l'affectation doit etre fait
    	if (compteuravantaffectation==0) {
        	// en fonction de si l'etat est nourrir ou nettoyer on change l'etat et on remet le compteur avant affectation à 50
    		// une fourmis dehors pour l'instant ne revient pas dans la fourmilliere
    		compteuravantaffectation=50;
	    	if(etat==States.NOURRIR || etat  == States.NETTOYER) {
	    		double choixetat = new Random().nextFloat(); // plus de chance de sortir
	    		if(choixetat>=0.5) {
	    			Terrain.addDessinable(this);
	    			etat=States.SUIVRE_PHEROMONES;
	    		}
	    		else if(choixetat<0.25) {
	    			etat=States.NETTOYER;
	    		}
	    		else {
	    			etat=States.NOURRIR;
	    		}
	    	}
    	}
    	
    	// on décrémente le compteur avant affectation
		compteuravantaffectation--;
    		
    	// si son etat est d'etre sur la carte alors on la fait bouger
    	if(etat==States.SUIVRE_PHEROMONES)
    		move();
    	
    	// si la fourmis meurt car duree de vie atteinte
    	if(RefAdulte.getDureevie()+1==RefAdulte.getDureevieMax()) {
    		// on la supprime de la liste si elle est dehors sans creer de cadavre
    		if(etat==States.SUIVRE_PHEROMONES){
        		// on l'efface du dessin
        		Terrain.removeDessinable(this);
    			getAdulte().getmaFourmi().getLaFourmiliere().removeFourmi(getAdulte().getmaFourmi());
    		}
    		// sinon on la transforme en cadavre qu'on stock dans le depot
    		else {
    			getAdulte().getmaFourmi().isDead();
    		}
    	}
    }

    public void move(){
    	
    	// génération aléatoire du mouvement
	  
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
	  r.traceForFourmiliere(this); // incrementation du nombre d'ouvrieres
	}
	
	public void nonnourris() { // si ouvriere non nourris
		// si dehors
		if(etat==States.SUIVRE_PHEROMONES){
			Terrain.removeDessinable(this); // on l'efface du desseins
			getAdulte().getmaFourmi().getLaFourmiliere().removeFourmi(getAdulte().getmaFourmi());
			// on l'efface de la fourmilliere en evitant le cadavre
		}
		//sinon
		else {
			getAdulte().getmaFourmi().isDead();
			//devient un cadavre stocker dans le depot
		}
	}
	  
	
}
