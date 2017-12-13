package Fourmi.Role;

import Fourmi.EtatDev.Adulte;

public class Soldat extends Role {

	 Adulte refAdulte=null;

	  public Soldat(Adulte monAdulte) {

		  refAdulte=monAdulte;

	  }


	  public Adulte getAdulte() {
		  return refAdulte;
	  }

}