package Fourmi.EtatDev;

import Fourmi.Fourmi;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Role;
import Fourmi.Role.Soldat;

public class Adulte extends EtatDev{
  Role role;
  
  public Adulte(Fourmi laFourmi) {
	  
	  double ouvriereousoldat = Math.random(); 
	  if (ouvriereousoldat < 0.7)
		  setRole(new Ouvriere(this));
	  else
		  setRole(new Soldat(this));
	  
  }
  
  public void cycle(){
	  role.cycle();
  }
  
  public void setRole(Role monRole) {
	  role =  monRole;
  }
}