package Fourmi.Role;

import Fourmi.Fourmi;
import Fourmiliere.Fourmiliere;
import Fourmi.EtatDev.EtatDev;
import creature.Cyclable;
import drawing.IMovableDrawable;
import monde.Zone;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;

public class Reine extends Role implements Cyclable{

  public Reine(Zone zone, EtatDev etatDev){
    super();
    this.etatDev = etatDev;
    this.zone = zone;
    createFourmiliere();
    this.etatDev.getFourmi().getFourmiliere().addFourmi(this.etatDev.getFourmi());
  }

  @Override
  public void cycle() {

    if(etatDev.getFourmi().getFourmiliere().getNb() < 500000){
      pond();
      //System.out.println("je pond " + etatDev.getFourmi().getFourmiliere().getNb());
    }
    //System.out.println("je joue " + etatDev.getFourmi().getFourmiliere().getNb());
  }

  public void pond(){
    new Fourmi(etatDev.getFourmi().getFourmiliere());
  }

  private void createFourmiliere(){
    etatDev.getFourmi().setFourmiliere(new Fourmiliere(this.getZone()));
  }
}
