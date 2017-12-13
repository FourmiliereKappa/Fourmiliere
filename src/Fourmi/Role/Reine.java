
package Fourmi.Role;

import java.util.Random;

import Fourmi.Fourmi;
import Fourmi.EtatDev.Adulte;
import Fourmiliere.Fourmiliere;
import monde.Terrain;
import suivi.Report;
import suivi.Trace;

public class Reine extends Role implements Trace{
	
  Adulte refAdulte;

  int compteuravantmanger = 100;

  Fourmiliere maFourmiliere;
  
  int dureevieReine = (int) (new Random().nextInt()*6+4) * 105120;  // nombre d'annee de vie de la reine  
  // * 288 nb cycle jour * 365 nb jour année
  
  public Reine(Terrain monTerrain) {
	 
	 maFourmiliere = new Fourmiliere(monTerrain);
	 
	 Fourmi maFourmi = new Fourmi(maFourmiliere);
	 Adulte monAdulte = new Adulte(maFourmi);
	 monAdulte.setRole(this);

	 maFourmi.setetatDev(monAdulte);
	 setrefAdulte(monAdulte);
	 
	 maFourmiliere.putFourmi(maFourmi);
	 
	 refAdulte.setDureevieMax(dureevieReine);
	 
  }
  
  public void cycle(){
	  
	  if(refAdulte.getDureevie()%50==0)
		  pondreoeuf();

  }
  
  public void setrefAdulte(Adulte monAdulte) {
	  refAdulte=monAdulte;
  }
  
  public void pondreoeuf() {
	 
	 maFourmiliere.nouvelleFourmi();
  }
  
  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this);
  }

}