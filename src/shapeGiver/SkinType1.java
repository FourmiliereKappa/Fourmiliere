package shapeGiver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import drawing.IMovableDrawable;
import drawing.Oval;

public class SkinType1 implements Dessineur{

  public SkinType1(){

  }


	  @Override
	  public IMovableDrawable dessine(Fourmi.Role.Ouvriere ouvriere) {
		  return new Oval(Color.BLACK, new Point(0, 0), new Dimension(5, 5));
	  }

	@Override
	public IMovableDrawable dessine(Fourmiliere.Fourmiliere fourmiliere) {
		 return new Oval(Color.PINK, new Point(0, 0), new Dimension(10, 10));
	}



}
