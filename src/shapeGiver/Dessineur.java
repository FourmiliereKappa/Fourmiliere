package shapeGiver;

import drawing.IMovableDrawable;
import Fourmiliere.Fourmiliere;
import Fourmi.Role.Ouvriere;

public interface Dessineur {

  public IMovableDrawable dessine(Ouvriere ouvriere);
  public IMovableDrawable dessine(Fourmiliere fourmiliere);

}
