package Fourmi.EtatDev;

import Fourmi.Fourmi;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Role;
import Fourmi.Role.Soldat;

public class Adulte extends EtatDev{
  Role role;
  
  public Adulte() {
	  double ouvriereousoldat = Math.random(); 
	  if (ouvriereousoldat < 0.5)
		  setRole(new Ouvriere());
	  else
		  setRole(new Soldat());
  }
  
  public void cycle(Fourmi laFourmi){
	  role.cycle();
  }
  
  public void setRole(Role monRole) {
	  role =  monRole;
  }
}
