package Fourmi;

import java.util.Random;

import Fourmi.EtatDev.EtatDev;
import Fourmi.EtatDev.Oeuf;
import Fourmiliere.Fourmiliere;

public class Fourmi {
	
  EtatDev etatDev;
  Fourmiliere lafourmilliere;
  double poids;
  States etat;
  
  
  public enum States {
		SUIVRE_PHEROMONES,
		NOURRIR,
		COMBATTRE,
		RETOUR
	}
  
  public Fourmi(Fourmiliere maFourmilliere) {
	  
	  
	  lafourmilliere=maFourmilliere;
	  etatDev = new Oeuf(this);  
	  poids = (float) (new Random().nextFloat()*0.5+1.5);
	  etat = States.SUIVRE_PHEROMONES;
	  
  }

  	
  public void cycle(){
    getetatDev().cycle();
  }
  
  public EtatDev getetatDev() {
	  return etatDev;
  }
  
  public Fourmiliere getLaFourmiliere() {
	  return lafourmilliere;
  }
  
  public void setetatDev(EtatDev etat) {
	  etatDev=etat;
  }
  
  public double getPoidFourmis() {
	  return poids;
  }
  
}