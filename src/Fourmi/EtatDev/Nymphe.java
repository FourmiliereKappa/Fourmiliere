package Fourmi.EtatDev;

import Fourmi.Fourmi;
import creature.Cyclable;

public class Nymphe extends EtatDev implements Cyclable {

  public Nymphe(Fourmi fourmi){
    super(fourmi);
  }

  public void cycle(){
    newStade();


  }

  public void newStade(){
    fourmi.setEtatDev(new Adulte(fourmi));
  }
}
