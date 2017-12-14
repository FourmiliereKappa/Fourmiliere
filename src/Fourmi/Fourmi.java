package Fourmi;

import java.util.Random;

import Depot.Cadavre;
import Fourmi.EtatDev.EtatDev;
import Fourmi.EtatDev.Oeuf;
import Fourmiliere.Fourmiliere;
import suivi.Report;
import suivi.Trace;

public class Fourmi implements Trace{
	
  EtatDev etatDev;
  Fourmiliere lafourmilliere;
  double poids;

  
  public Fourmi(Fourmiliere maFourmilliere) {
	  
	  
	  lafourmilliere=maFourmilliere;
	  etatDev = new Oeuf(this);  // La nouvelle fourmis devient un oeuf au debut de son cycle
	  poids = (float) (new Random().nextFloat()*0.5+1.5); // calcul poid fourmis
	  
  }

  	
  public void cycle(){
    getetatDev().cycle(); //lancement du cycle
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
	r.traceForFourmiliere(this);	// incrementation du compteur des fourmis
  }
  
  public double getPoidFourmis() {
	  return poids;
  }
  
  public void isDead() {
	  // si la fourmis est morte dans la fourmilliere on l'efface de la fourmilliere et 
	  //on crée un nouveau cadavre qu'on ajoute au depot
	  getLaFourmiliere().removeFourmi(this);
	  getLaFourmiliere().getDepot().ajoutCadavre(new Cadavre());
  }
  
}