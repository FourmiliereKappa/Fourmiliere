package Fourmi.EtatDev;

import Fourmi.Fourmi;

public class Oeuf extends EtatDev {
	
  int vie = 0 ;
  int dureeviemax = 864; // 3 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux

  public void cycle(Fourmi laFourmi){
	  
	  if (vie==dureeviemax) {
		  
		  Larve malarve = new Larve();
		  laFourmi.setetatDev(malarve);
		  
	  }else {
		  vie ++;
	  }
  }

}
