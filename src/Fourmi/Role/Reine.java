
package Fourmi.Role;

import java.util.Random;

import Fourmi.Fourmi;
import Fourmi.EtatDev.Adulte;
import Fourmiliere.Fourmiliere;
import monde.Terrain;
import suivi.Report;
import suivi.Trace;

public class Reine extends Role implements Trace{
	
  Adulte refAdulte; // référence vers l'adulte
  
  int dureevieReine = (int) (new Random().nextInt()*6+4) * 105120;  // nombre d'annee de vie de la reine  
  // * 288 nb cycle jour * 365 nb jour année
  
  public Reine(Terrain monTerrain) {
	 
	 Fourmiliere maFourmiliere = new Fourmiliere(monTerrain); // la reine est liée à une fourmilliere
	 
	 Fourmi maFourmi = new Fourmi(maFourmiliere); // on l'ajoute dans la fourmiliere
	 Adulte monAdulte = new Adulte(maFourmi);
	 monAdulte.setRole(this);

	 maFourmi.setetatDev(monAdulte);
	 setrefAdulte(monAdulte);
	 
	 maFourmiliere.putFourmi(maFourmi);
	 
	 refAdulte.setDureevieMax(dureevieReine); // on redéfini sa durée de vie
	 
  }
  
  public void cycle(){
	  
	  if(refAdulte.getDureevie()%50==0) // tout les 50 frames avec la frame 0 la reine pond
		  pondreoeuf();
	  
	  if(refAdulte.getDureevie() == refAdulte.getDureevieMax()) { // si elle arrive à sa durée de viemax elle meurt
		  refAdulte.getmaFourmi().isDead();
	  }

  }
  
  public void setrefAdulte(Adulte monAdulte) {
	  refAdulte=monAdulte;
  }
  
  public void pondreoeuf() { // la reine crée une nouvelle fourmis
	 
	 refAdulte.getmaFourmi().getLaFourmiliere().nouvelleFourmi();
  }
  
  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this);// incrementation du nombre de reines
  }
  
  
  public void nonnourris() {
	  refAdulte.getmaFourmi().isDead(); // si non nourris la reine meurt et devient un cadavre
  }

}