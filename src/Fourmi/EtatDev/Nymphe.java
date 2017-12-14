package Fourmi.EtatDev;

import Fourmi.Fourmi;
import suivi.Report;
import suivi.Trace;

public class Nymphe extends EtatDev implements Trace {
	
  int vie = 0 ; // période que la nymphe à vécue
  int dureeviemax = 1728; // 6 = nb jours * 288 nb tics jours = tics totaux
  Fourmi refFourmis; // référence vers la fourmis
  
  public Nymphe(Fourmi maFourmi) {
	  refFourmis = maFourmi;
  }

  public void cycle(){ //lancement de se que fait la nymphe pendant un cycle
	  
	  // si ca période de vie passée est égale à sa durée de vie avant évolution alors elle évolue en adulte
	  if (vie==dureeviemax) {
		  Adulte monadulte = new Adulte(getrefFourmis()); // création d'un adulte qui devient le nouvel etat de la fourmis
		  getrefFourmis().setetatDev(monadulte);
	  }else {
		  vie ++; // sinon incrementation de la période de vie passée
	  }
  }
  
  public Fourmi getrefFourmis() {
	  return refFourmis;
  }

  // 
  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this); // incrementation du nombre de nymphes
  }
  
  
}