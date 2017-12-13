package Fourmi.EtatDev;

import java.util.Random;

import Fourmi.Fourmi;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Role;
import Fourmi.Role.Soldat;
import suivi.Report;
import suivi.Trace;

public class Adulte extends EtatDev implements Trace{
	
  Role role;
  Fourmi maFourmi;
  int dureevie = 0;
  int dureeviemax= (int) ((new Random().nextFloat()+1.5) *288 * 365);  // nombre d'annee de vie de la fourmis
  // * 288 nb cycle jour * 365 nb jour année
  int compteuravantmanger = 288; // on nourris la fourmis une fois par jour
  
  public Adulte(Fourmi laFourmi) {
	  
	  maFourmi = laFourmi;
	  
	  double ouvriereousoldat = Math.random(); 
	  if (ouvriereousoldat < 0.7)
		  setRole(new Ouvriere(this));
	  else
		  setRole(new Soldat(this));
	  
	  
  }
  
  public void cycle(){
	  
	  if(dureevie==dureeviemax) {
		  getmaFourmi().isDead();
	  }
	  dureevie++;
	  compteuravantmanger--;
	  
	  if(compteuravantmanger==0) {
		  
		  boolean resultsinourris = getmaFourmi().getLaFourmiliere().nourrir(getmaFourmi().getPoidFourmis());
		  if(resultsinourris==true) {
			  compteuravantmanger=288;
		  }
		  else {
			  getmaFourmi().isDead();
			  getRole().nonnourris();
		  }
	  }
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
  public void trace(Report r) {
  	r.traceForFourmiliere(this);
  	this.getRole().trace(r);
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