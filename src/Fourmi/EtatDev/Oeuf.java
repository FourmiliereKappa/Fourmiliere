package Fourmi.EtatDev;

import Fourmi.Fourmi;
import suivi.Report;
import suivi.Trace;

public class Oeuf extends EtatDev implements Trace {
	
  int vie = 0 ;
  int dureeviemax = 864; // 3 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux
  Fourmi refFourmis; // r�f�rence vers la fourmis
  
  public Oeuf(Fourmi maFourmi) {
	  refFourmis = maFourmi;
  }
  
  
  public void cycle(){
	  
	// si ca p�riode de vie pass�e est �gale � sa dur�e de vie avant �volution alors elle �volue en larve
	  if (vie==dureeviemax) {
		  
		  Larve malarve = new Larve(getrefFourmis());//cr�ation d'une larve qui devient le nouvel etat de la fourmis
		  getrefFourmis().setetatDev(malarve);
		  
	  }else {
		  vie ++;// sinon on incr�mente la p�ridoe de vie pass�e de la fourmis
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