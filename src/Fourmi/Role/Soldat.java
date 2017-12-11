package Fourmi.Role;

import Fourmi.EtatDev.Adulte;

public class Soldat extends Role {
	
	Adulte refAdulte;
	
  public Soldat(Adulte monAdulte) {
	  
	  System.out.println("Je suis un soldat");
	  refAdulte=monAdulte;
	  
  }

  public void cycle(){
	  
  }
  
  public Adulte getAdulte() {
	  return refAdulte;
  }

}
