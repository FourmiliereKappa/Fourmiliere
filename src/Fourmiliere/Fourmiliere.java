package Fourmiliere;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Fourmi;
import creature.Cyclable;
import drawing.IMovableDrawable;
import monde.Zone;
import monde.theWorld;
import shapeGiver.Dessinable;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;

public class Fourmiliere implements Dessinable, Cyclable{

  private List<Fourmi> fourmis;
  private Zone zone;
  private IMovableDrawable skin;

  public Fourmiliere(Zone zone) {
    fourmis = new CopyOnWriteArrayList<Fourmi>();
    this.zone = zone;

    Dessineur dessineur = new SkinType1();
    skin = accept(dessineur);
    theWorld.addDessinable(this);
    theWorld.addCyclable(this);
  }

  public Zone getZone(){
    return zone;
  }

  public int getNb(){
    return fourmis.size();
  }

  public void addFourmi(Fourmi fourmi) {
    fourmis.add(fourmi);
  }

  @Override
  public IMovableDrawable accept(Dessineur dessineur) {
    return dessineur.dessine(this);
  }

  @Override
  public IMovableDrawable getSkin() {
    return skin;
  }

  @Override
  public int getX() {
    return zone.getX();
  }

  @Override
  public int getY() {
    return zone.getY();
  }

  @Override
  public void cycle() {
    for(Fourmi fourmi : fourmis){
      fourmi.cycle();
    }
  }
}
