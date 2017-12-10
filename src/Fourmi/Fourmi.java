package Fourmi;

import Fourmi.EtatDev.EtatDev; 
import Fourmiliere.Fourmiliere;

public class Fourmi {
	
  EtatDev etatDev;
  Fourmiliere lafourmilliere;
  
  public Fourmi(Fourmiliere maFourmilliere,EtatDev monetat) {
	  
	  lafourmilliere=maFourmilliere;
	  etatDev=monetat;
	  
  }

  	
  public void cycle(Fourmi maFourmis){
    getetatDev().cycle(maFourmis);
  }
  
  public EtatDev getetatDev() {
	  return etatDev;
  }
  
  public void setetatDev(EtatDev etat) {
	  etatDev=etat;
  }
}
