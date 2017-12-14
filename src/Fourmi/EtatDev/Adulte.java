package Fourmi.EtatDev;

import java.util.Random;

import Fourmi.Fourmi;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Role;
import Fourmi.Role.Soldat;
import suivi.Report;
import suivi.Trace;

public class Adulte extends EtatDev implements Trace{
	
  Role role; // le role de la fourmis 
  Fourmi maFourmi; //reference vers la fourmis
  int dureevie = 0; // le temps que la fourmis à vécue en nb de cycle
  int dureeviemax= (int) ((new Random().nextFloat()+1.5) *288 * 365);  // nombre d'annee de vie de la fourmis
  // * 288 nb cycle jour * 365 nb jour année = temps vie total en cycle
  int compteuravantmanger = 288; // on nourris la fourmis une fois par jour
  
  public Adulte(Fourmi laFourmi) {
	  
	  maFourmi = laFourmi;
	  
	  double ouvriereousoldat = Math.random(); // définition aléatorie du role de la fourmis entre soldat et ouvriere 
	  //( plus de chance pour ouvriere -> 70% )
	  if (ouvriereousoldat < 0.7)
		  setRole(new Ouvriere(this));
	  else
		  setRole(new Soldat(this));
	  
	  
  }
  
  public void cycle(){
	  // si la fourmie arrive à sa vie max elle meurt et devient un cadavre
	  if(dureevie==dureeviemax) {
		  getmaFourmi().isDead();
	  }
	  
	  // incrementation du temps que la fourmis à vécue
	  dureevie++;
	  // decrementation du compteur avant manger
	  compteuravantmanger--;
	  
	  // si la fourmis doit manger
	  if(compteuravantmanger==0) {
		  
		  // on regarde si elle peut manger
		  boolean resultsinourris = getmaFourmi().getLaFourmiliere().nourrir(getmaFourmi().getPoidFourmis());
		  // si oui on relance le compteur
		  if(resultsinourris==true) {
			  compteuravantmanger=288;
		  }
		  // si non elle meurt
		  else {
			  getRole().nonnourris();
		  }
	  }
	  
	  // on lance le cycle du role de la fourmis
	  role.cycle();
  }
  
  public Fourmi getmaFourmi() {
	  return maFourmi;
  }
  
  public void setRole(Role monRole) {
	  role =  monRole;
  }
  
  public Role getRole() {
	  return role;
  }
  
  @Override
  public void trace(Report r) { // comptage du nombre d'adulte -> incrémentation
  	r.traceForFourmiliere(this);
  	this.getRole().trace(r); // pour comptage du role spécifique de la fourmis
  }
  
  public void setDureevieMax(int dureeviemax) {
	  this.dureeviemax=dureeviemax;
  }
  
  public int getDureevieMax() {
	  return dureeviemax;
  }
  
  public int getDureevie() {
	  return dureevie;
  }
  
  
  
  
}