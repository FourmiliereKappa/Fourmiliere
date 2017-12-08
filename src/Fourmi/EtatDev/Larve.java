package Fourmi.EtatDev;

import Fourmi.Fourmi;

public class Larve extends EtatDev {
	
  int vie = 0 ;
  int dureeviemax=2880; //10 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux


  public void cycle(Fourmi laFourmi){
	  if (vie==dureeviemax) {
		  Nymphe manymphe = new Nymphe();
		  laFourmi.setetatDev(manymphe);
	  }else {
		  vie ++;
	  }
  }

}
