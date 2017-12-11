
package Fourmi.Role;

import Fourmi.Fourmi;
import Fourmi.EtatDev.Adulte;
import Fourmiliere.Fourmiliere;

public class Reine extends Role {
	
  Adulte refAdulte;

  int dureviee=0;
  int dureeviemax=1051200;

  Fourmiliere maFourmiliere;
  
  public Reine() {
	  
	 maFourmiliere = new Fourmiliere();
	 
	 Fourmi maFourmi = new Fourmi(maFourmiliere);
	 Adulte monAdulte = new Adulte(maFourmi);
	 monAdulte.setRole(this);

	 maFourmi.setetatDev(monAdulte);
	 setrefAdulte(monAdulte);
	 
	 maFourmiliere.putFourmi(maFourmi);
	 
  }
  //
  public void cycle(){
	  
	  
	  pondreoeuf();
	  dureviee+=1;

  }
  
  public void setrefAdulte(Adulte monAdulte) {
	  refAdulte=monAdulte;
  }
  
  public void pondreoeuf() {
	 
	 maFourmiliere.nouvelleFourmi();
  }

}