package Fourmi.EtatDev;

import Fourmi.Fourmi;
import suivi.Report;
import suivi.Trace;

public class Oeuf extends EtatDev implements Trace {
	
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

  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this);
  }
  
}