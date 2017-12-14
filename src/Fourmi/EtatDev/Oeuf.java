package Fourmi.EtatDev;

import Fourmi.Fourmi;
import suivi.Report;
import suivi.Trace;

public class Oeuf extends EtatDev implements Trace {
	
  int vie = 0 ;
  int dureeviemax = 864; // 3 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux
  Fourmi refFourmis; // référence vers la fourmis
  
  public Oeuf(Fourmi maFourmi) {
	  refFourmis = maFourmi;
  }
  
  
  public void cycle(){
	  
	// si ca période de vie passée est égale à sa durée de vie avant évolution alors elle évolue en larve
	  if (vie==dureeviemax) {
		  
		  Larve malarve = new Larve(getrefFourmis());//création d'une larve qui devient le nouvel etat de la fourmis
		  getrefFourmis().setetatDev(malarve);
		  
	  }else {
		  vie ++;// sinon on incrémente la péridoe de vie passée de la fourmis
	  }
  }
  
  public Fourmi getrefFourmis() {
	  return refFourmis;
  }

  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this); // incrementation du nombre d'oeufs pour affichage.
  }
  
}