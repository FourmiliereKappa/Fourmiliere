package Fourmi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import Fourmi.EtatDev.Adulte;
import Fourmi.EtatDev.EtatDev;
import Fourmi.EtatDev.Oeuf;
import Fourmiliere.Fourmiliere;
import Fourmi.Role.Reine;
import creature.Cyclable;
import drawing.IMovableDrawable;
import drawing.Oval;
import monde.Zone;
import monde.theWorld;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;
import monde.Direction;

public class Fourmi implements Cyclable{


  private EtatDev etatDev;
  private Fourmiliere fourmiliere;

  public Fourmi(Fourmiliere fourmiliere){
    etatDev = new Oeuf(this);
    this.fourmiliere = fourmiliere;
    fourmiliere.addFourmi(this);
  }

  public Fourmi(){
    Zone zoneStart = new Zone(0, 0);
    etatDev = new Adulte(this, zoneStart);
  }

  public Fourmiliere getFourmiliere(){
    return fourmiliere;
  }

  public void setFourmiliere(Fourmiliere fourmiliere){
    this.fourmiliere = fourmiliere;
  }

  public void setEtatDev(EtatDev etatDev){
    this.etatDev = etatDev;
  }

  @Override
  public void cycle() {
    etatDev.cycle();
  }
}
