package shapeGiver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import drawing.IMovableDrawable;
import drawing.Oval;
import Fourmiliere.Fourmiliere;
import creature.Insecte;
import creature.Puce;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Soldat;

public class SkinType1 implements Dessineur{

  public SkinType1(){

  }

  @Override
  public IMovableDrawable dessine(Ouvriere ouvriere) {
    return new Oval(Color.BLACK, new Point(0, 0), new Dimension(5, 5));
  }

  @Override
  public IMovableDrawable dessine(Fourmiliere fourmiliere) {
    return new Oval(Color.PINK, new Point(0, 0), new Dimension(10, 10));
  }

  @Override
  public IMovableDrawable dessine(Soldat soldat) {
    return new Oval(Color.RED, new Point(0, 0), new Dimension(5, 5));
  }

  @Override
  public IMovableDrawable dessine(Insecte insecte) {
    return new Oval(Color.BLUE, new Point(0, 0), new Dimension(3, 3));
  }

  @Override
  public IMovableDrawable dessine(Puce puce) {
    return new Oval(Color.RED, new Point(0, 0), new Dimension(3, 3));
  }



}
