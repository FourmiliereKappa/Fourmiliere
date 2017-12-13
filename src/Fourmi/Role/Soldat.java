package Fourmi.Role;

import Fourmi.EtatDev.Adulte;
import suivi.Report;
import suivi.Trace;

public class Soldat extends Role implements Trace{

	  Adulte refAdulte=null;

	  public Soldat(Adulte monAdulte) {

		  refAdulte=monAdulte;

	  }


	  public Adulte getAdulte() {
		  return refAdulte;
	  }

	  @Override
	  public void trace(Report r) {
	  	r.traceForFourmiliere(this);
	  }
	  
	  public void cycle() {
		  if(refAdulte.getDureevie()+1==refAdulte.getDureevieMax()) {
			  getAdulte().getmaFourmi().isDead();
		  }
	  }
	  
	  public void nonnourris() {
			getAdulte().getmaFourmi().isDead();
	  }
		  
	  
}