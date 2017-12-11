package Fourmi.Role;

import Fourmi.EtatDev.Adulte;

public class Ouvriere extends Role {
	
	Adulte RefAdulte;
	
	public Ouvriere(Adulte monAdulte) {
		
		System.out.println("Je suis une ouvriere");
		RefAdulte = monAdulte;
		
	}
	

  public void cycle(){
	  
  }
  
  public Adulte getAdulte() {
	  return RefAdulte;
  }

}
