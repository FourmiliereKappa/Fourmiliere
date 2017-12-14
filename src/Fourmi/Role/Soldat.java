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
	  public void trace(Report r) { // incrementation du nombre de soldates
	  	r.traceForFourmiliere(this);
	  }
	  
	  public void cycle() {
		  if(refAdulte.getDureevie()==refAdulte.getDureevieMax()) { // si duree de vie max atteinte alors la fourmis meurt
			  getAdulte().getmaFourmi().isDead();
		  }
	  }
	  
	  public void nonnourris() { // si non nourris elle meurt
			getAdulte().getmaFourmi().isDead();
	  }
		  
	  
}