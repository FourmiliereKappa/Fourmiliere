package Fourmi.EtatDev;

import Fourmi.Fourmi;

public class Oeuf extends EtatDev {
	
  int vie = 0 ;
  int dureeviemax = 864; // 3 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux

  public void cycle(Fourmi laFourmi){
	  
	  System.out.println("tics :" + vie);
	  if (vie==dureeviemax) {
		  System.out.println("Larve creation");
		  Larve malarve = new Larve();
		  laFourmi.setetatDev(malarve);
		  malarve.cycle(laFourmi);
	  }else {
		  vie ++;
	  }
  }

}
