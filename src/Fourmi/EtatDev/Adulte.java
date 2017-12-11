package Fourmi.EtatDev;

import Fourmi.Fourmi;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Reine;
import Fourmi.Role.Role;
import drawing.IMovableDrawable;
import monde.Zone;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;

public class Adulte extends EtatDev{

  Role role;

  public Adulte(Fourmi fourmi){
    super(fourmi);
    role = new Ouvriere(fourmi.getFourmiliere().getZone(), this);
  }

  public Adulte(Fourmi fourmi, Zone zone){
    super(fourmi);
    role = new Reine(zone, this);
  }


  public void setRole(Role role){
    this.role = role;
  }

  public void cycle(){
    role.cycle();
  }

  public void newStade(){
    fourmi.setEtatDev(new Adulte(fourmi));
  }

}
