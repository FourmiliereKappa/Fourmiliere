package Fourmi.EtatDev;

import Fourmi.Fourmi;
import suivi.Report;
import suivi.Trace;

public class Larve extends EtatDev implements Trace {
	
  int vie = 0 ;
  int dureeviemax=2880; //10 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux
  Fourmi refFourmis;
  double poids=0;
  double multiplicateurpoidentrefourmisetlarve =  3.5 ;
  
  public Larve(Fourmi maFourmi) {
	  refFourmis = maFourmi;
	  poids = getrefFourmis().getPoidFourmis() * multiplicateurpoidentrefourmisetlarve;
  }

  public void cycle(){
		  
	  if (vie==dureeviemax) {
		  Nymphe manymphe = new Nymphe(getrefFourmis());
		  getrefFourmis().setetatDev(manymphe);
		  }else {
			  vie ++;
		  } 
  }
  
  public Fourmi getrefFourmis() {
	  return refFourmis;
  }
  
  public double getPoids() {
	  return poids;
  }
  
  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this);
  }
  
  
}
