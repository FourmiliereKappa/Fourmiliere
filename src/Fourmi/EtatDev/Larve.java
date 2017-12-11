package Fourmi.EtatDev;

import Fourmi.Fourmi;
import creature.Cyclable;

public class Larve extends EtatDev implements Cyclable {

  public Larve(Fourmi fourmi){
    super(fourmi);
  }

  public void cycle(){
    newStade();
  }

  public void newStade(){
    fourmi.setEtatDev(new Nymphe(fourmi));
  }
}
