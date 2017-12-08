package Fourmi;

import Fourmi.EtatDev.EtatDev;
import Fourmi.EtatDev.Oeuf;
import Fourmiliere.Fourmiliere;

public class Fourmi {
  EtatDev etatDev;
  Fourmiliere lafourmilliere;
  
  public Fourmi(Fourmiliere maFourmilliere) {
	  lafourmilliere=maFourmilliere;
	  etatDev = new Oeuf();
	  cycle(this);
  }

  public void cycle(Fourmi maFourmis){
    etatDev.cycle(maFourmis);
  }
  
  public EtatDev getetatDev() {
	  return etatDev;
  }
  
  public void setetatDev(EtatDev etat) {
	  etatDev=etat;
  }
}
