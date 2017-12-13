package Fourmi;

import Fourmi.EtatDev.EtatDev;
import Fourmi.EtatDev.Oeuf;
import Fourmiliere.Fourmiliere;
import suivi.Report;
import suivi.Trace;

public class Fourmi implements Trace{
	
  EtatDev etatDev;
  Fourmiliere lafourmilliere;
  
  public Fourmi(Fourmiliere maFourmilliere) {
	  
	  
	  lafourmilliere=maFourmilliere;
	  etatDev = new Oeuf(this);  
	  
  }

  	
  public void cycle(){
    getetatDev().cycle();
    
  }
  
  public EtatDev getetatDev() {
	  return etatDev;
  }
  
  public Fourmiliere getLaFourmiliere() {
	  return lafourmilliere;
  }
  
  public void setetatDev(EtatDev etat) {
	  etatDev=etat;
  }


@Override
public void trace(Report r) {
	r.traceForFourmiliere(this);
}
  
}