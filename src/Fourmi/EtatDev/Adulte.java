package Fourmi.EtatDev;

import Fourmi.Fourmi;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Role;
import Fourmi.Role.Soldat;

public class Adulte extends EtatDev{
	
  Role role;
  Fourmi maFourmi;
  int dureevie=0;
  int dureeviemax=0;
  
  public Adulte(Fourmi laFourmi) {
	  
	  maFourmi = laFourmi;
	  
	  double ouvriereousoldat = Math.random(); 
	  if (ouvriereousoldat < 0.7)
		  setRole(new Ouvriere(this));
	  else
		  setRole(new Soldat(this));
	  
	  
  }
  
  public void cycle(){
	  role.cycle();
	  dureevie++;
  }
  
  public Fourmi getmaFourmi() {
	  return maFourmi;
  }
  
  public void setRole(Role monRole) {
	  role =  monRole;
  }
}