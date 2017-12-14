package Fourmi.EtatDev;

import Fourmi.Fourmi;
import suivi.Report;
import suivi.Trace;

public class Larve extends EtatDev implements Trace {
	
  int vie = 0 ; // vie en frame que la fourmis à vécue
  int dureeviemax=2880; //10 = nombre de jours * 288 = nombre de tics par jour = nombre de tics totaux avant évolution en nymphe
  Fourmi refFourmis;
  double poids=0; // poids de la larve
  double multiplicateurpoidentrefourmisetlarve =  3.5 ; // triple du poids de la fourmis à peut près
  int compteuravantmanger = 288; // compteur avant qu'elle mange en cycle ( une fois par jour )
  
  public Larve(Fourmi maFourmi) {
	  
	  refFourmis = maFourmi;
	// définition du poids par rapport au poids de la fourmis et à son multiplicateur
	  poids = getrefFourmis().getPoidFourmis() * multiplicateurpoidentrefourmisetlarve; 
	  
  }

  public void cycle(){
		  
	  // si la larve arrive à sa vie maximum on créer une nymphe qui devient le nouvel etat de la fourmis
	  if (vie==dureeviemax) {
		  Nymphe manymphe = new Nymphe(getrefFourmis());
		  getrefFourmis().setetatDev(manymphe);
	  } 
	  //sinon la période que la larve à vécue est incrémentée
	  else {
		  vie ++;
	  } 
	  
	  // on diminue le compteur avant manger 
	  compteuravantmanger--;
	  
	  // si la larve doit manger
	  if (compteuravantmanger==0) {
		  // on regarde si elle peut manger par rapport à la réserve de nourriture restante
		  boolean resultsinourris = getrefFourmis().getLaFourmiliere().nourrir(getrefFourmis().getPoidFourmis());
		  // si oui on remet le compteur 
		  if(resultsinourris==true) {
			  compteuravantmanger=288;
		  }
		  // si non la larve meurt et la fourmis avec. Elle devient alors un cadavre
		  else {
			  getrefFourmis().isDead();
		  }
	  }
	  
  }
  
  public Fourmi getrefFourmis() {
	  return refFourmis;
  }
  
  public double getPoids() {
	  return poids;
  }
  
  // incrémentation du compteur pour les larves
  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this);
  }
  
  
}
