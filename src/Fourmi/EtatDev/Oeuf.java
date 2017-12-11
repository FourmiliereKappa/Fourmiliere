package Fourmi.EtatDev;

import Fourmi.Fourmi;

public class Oeuf extends EtatDev {
	
  int vie = 0 ;
  int dureeviemax = 864; // 3 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux
  Fourmi refFourmis;
  
  public Oeuf(Fourmi maFourmi) {
	  refFourmis = maFourmi;
  }
  
  
  public void cycle(){
	  
	  
	  if (vie==dureeviemax) {
		  
		  Larve malarve = new Larve(getrefFourmis());
		  getrefFourmis().setetatDev(malarve);
		  
	  }else {
		  vie ++;
	  }
  }
  
  public Fourmi getrefFourmis() {
	  return refFourmis;
  }

}