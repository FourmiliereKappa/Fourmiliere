package Fourmi.EtatDev;

import Fourmi.Fourmi;
import creature.Cyclable;

public abstract class EtatDev implements Cyclable{

  Fourmi fourmi;

  public EtatDev(Fourmi fourmi){
    this.fourmi = fourmi;
  }

  public Fourmi getFourmi(){
    return fourmi;
  }

  public void cycle(){

  }
}
