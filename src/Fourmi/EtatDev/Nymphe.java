package Fourmi.EtatDev;

import Fourmi.Fourmi;

public class Nymphe extends EtatDev {
	
  int vie = 0 ;
  int dureeviemax = 1728; // 6 = nb jours * 288 nb tics jours = tics totaux

  public void cycle(Fourmi laFourmi){
	  if (vie==dureeviemax) {
		  System.out.println("Fin cycle Nymphe");
		  Adulte monadulte = new Adulte();
		  laFourmi.setetatDev(monadulte);
	  }else {
		  vie ++;
	  }
  }

}