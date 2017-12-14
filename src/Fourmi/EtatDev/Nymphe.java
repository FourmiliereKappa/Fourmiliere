package Fourmi.EtatDev;

import Fourmi.Fourmi;
import suivi.Report;
import suivi.Trace;

public class Nymphe extends EtatDev implements Trace {
	
  int vie = 0 ; // p�riode que la nymphe � v�cue
  int dureeviemax = 1728; // 6 = nb jours * 288 nb tics jours = tics totaux
  Fourmi refFourmis; // r�f�rence vers la fourmis
  
  public Nymphe(Fourmi maFourmi) {
	  refFourmis = maFourmi;
  }

  public void cycle(){ //lancement de se que fait la nymphe pendant un cycle
	  
	  // si ca p�riode de vie pass�e est �gale � sa dur�e de vie avant �volution alors elle �volue en adulte
	  if (vie==dureeviemax) {
		  Adulte monadulte = new Adulte(getrefFourmis()); // cr�ation d'un adulte qui devient le nouvel etat de la fourmis
		  getrefFourmis().setetatDev(monadulte);
	  }else {
		  vie ++; // sinon incrementation de la p�riode de vie pass�e
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