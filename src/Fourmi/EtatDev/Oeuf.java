package Fourmi.EtatDev;

import Fourmi.Fourmi;
import creature.Cyclable;

public class Oeuf extends EtatDev implements Cyclable {


  public Oeuf(Fourmi fourmi){
    super(fourmi);
  }

  public void cycle(){
    newStade();
  }

  public void newStade(){
    fourmi.setEtatDev(new Larve(fourmi));
  }

}
