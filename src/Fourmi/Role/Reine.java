package Fourmi.Role;

import Fourmi.Fourmi;
import Fourmi.EtatDev.Adulte;
import Fourmiliere.Fourmiliere;

public class Reine extends Role {

  int dureviee=0;
  int dureeviemax=10*365;

  Fourmiliere maFourmiliere;
  
  public Reine() {
	  
	 maFourmiliere = new Fourmiliere();
	 Fourmi maFourmi = new Fourmi(maFourmiliere);
	 Adulte monAdulte = new Adulte();
	 monAdulte.setRole(this);
	 maFourmi.setetatDev(monAdulte);
	 maFourmiliere.putFourmi(maFourmi);
  }
  
  public void cycle(){
	  
	  pondreoeuf();

  }
  
  public void pondreoeuf() {
	  maFourmiliere.nouvelleFourmi();
  }

}
