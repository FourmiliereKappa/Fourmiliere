
package Fourmi.Role;

import Fourmi.Fourmi;
import Fourmi.EtatDev.Adulte;
import Fourmiliere.Fourmiliere;
import monde.Terrain;
import suivi.Report;
import suivi.Trace;

public class Reine extends Role implements Trace{
	
  Adulte refAdulte;

  int dureviee=0;
  int dureeviemax=1051200;

  Fourmiliere maFourmiliere;
  
  public Reine(Terrain monTerrain) {
	 
	 maFourmiliere = new Fourmiliere(monTerrain);
	 
	 Fourmi maFourmi = new Fourmi(maFourmiliere);
	 Adulte monAdulte = new Adulte(maFourmi);
	 monAdulte.setRole(this);

	 maFourmi.setetatDev(monAdulte);
	 setrefAdulte(monAdulte);
	 
	 maFourmiliere.putFourmi(maFourmi);
	 
  }
  //
  public void cycle(){
	  
	  if (dureviee%50 == 0) {
		  
		  pondreoeuf();//
		  
	  }
	  dureviee+=1;

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