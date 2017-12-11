package Fourmi.Role;

import Fourmi.EtatDev.EtatDev;
import creature.Cyclable;
import drawing.IMovableDrawable;
import monde.Zone;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;

public abstract class Role implements Cyclable{

  protected Zone zone;
  protected EtatDev etatDev;

  public Role(EtatDev etatDev){
    this.etatDev = etatDev;
    this.zone = this.etatDev.getFourmi().getFourmiliere().getZone();
  }

  public Role(){
  }

  public Zone getZone() {
    return zone;
  }

  public int getX() {
    return zone.getX();
  }

  public int getY() {
    return zone.getY();
  }

  public void cycle(){

  }


}
