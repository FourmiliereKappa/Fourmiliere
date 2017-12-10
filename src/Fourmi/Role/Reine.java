package Fourmi.Role;

import Fourmi.Fourmi;
import Fourmi.EtatDev.Adulte;
import Fourmiliere.Fourmiliere;

public class Reine extends Role {

  int dureviee=0;
  int dureeviemax=1051200;

  Fourmiliere maFourmiliere;
  
  public Reine() {
	  
	 maFourmiliere = new Fourmiliere();
	 Adulte monAdulte = new Adulte();
	 monAdulte.setRole(this);
	 Fourmi maFourmi = new Fourmi(maFourmiliere, monAdulte);
	 maFourmiliere.putFourmi(maFourmi);
	 
  }
  //
  public void cycle(){
	  
	  pondreoeuf();
	  dureviee+=1;

  }
  
  public void pondreoeuf() {
	 
	 maFourmiliere.nouvelleFourmi();
  }

}
