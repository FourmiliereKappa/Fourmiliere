package Fourmi.EtatDev;

import Fourmi.Fourmi;

public class Larve extends EtatDev {
	
  int vie = 0 ;
  int dureeviemax=2880; //10 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux
  Fourmi refFourmis;
  
  public Larve(Fourmi maFourmi) {
	  refFourmis = maFourmi;
  }

  public void cycle(){
		  
	  if (vie==dureeviemax) {
		  Nymphe manymphe = new Nymphe(getrefFourmis());
		  getrefFourmis().setetatDev(manymphe);
		  }else {
			  vie ++;
		  } 
  }
  
  public Fourmi getrefFourmis() {
	  return refFourmis;
  }
  
}
