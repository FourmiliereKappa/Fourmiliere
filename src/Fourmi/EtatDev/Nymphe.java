package Fourmi.EtatDev;

import Fourmi.Fourmi;

public class Nymphe extends EtatDev {
	
  int vie = 0 ;
  int dureeviemax = 1728; // 6 = nb jours * 288 nb tics jours = tics totaux
  Fourmi refFourmis;
  
  public Nymphe(Fourmi maFourmi) {
	  refFourmis = maFourmi;
  }

  public void cycle(){
	  
	  if (vie==dureeviemax) {
		  Adulte monadulte = new Adulte(getrefFourmis());
		  getrefFourmis().setetatDev(monadulte);
	  }else {
		  vie ++;
	  }
  }
  
  public Fourmi getrefFourmis() {
	  return refFourmis;
  }

}