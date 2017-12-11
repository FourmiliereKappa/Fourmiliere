package shapeGiver;

import Fourmi.Role.Ouvriere;
import Fourmiliere.Fourmiliere;
import drawing.IMovableDrawable;


public interface Dessineur {

  public IMovableDrawable dessine(Ouvriere ouvriere);
  public IMovableDrawable dessine(Fourmiliere fourmiliere);

}
