package shapeGiver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import drawing.IMovableDrawable;
import drawing.Oval;
import drawing.RectangleDrawable;
import Fourmiliere.Fourmiliere;
import creature.Ennemi;
import Fourmi.Role.Ouvriere;

public class SkinType1 implements Dessineur{

  public SkinType1(){

  }

  @Override
  public IMovableDrawable dessine(Ouvriere ouvriere) {
    return new Oval(Color.BLACK, new Point(0, 0), new Dimension(5, 5));
  }

  @Override
  public IMovableDrawable dessine(Fourmiliere fourmiliere) {
    return new RectangleDrawable(Color.PINK, new Point(0, 0), new Dimension(15, 15));
  }

  @Override
  public IMovableDrawable dessine(Ennemi ennemi) {
    int bounds= 5*(int)Math.ceil((Math.sqrt(ennemi.getPoids())/2));

    return new Oval(Color.RED, new Point(0, 0), new Dimension(bounds, bounds));
  }




}
