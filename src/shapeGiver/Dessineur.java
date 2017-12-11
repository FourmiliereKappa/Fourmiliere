package shapeGiver;

import drawing.IMovableDrawable;
import fourmiliere.Fourmiliere;
import fourmis.Fourmi;
import fourmis.role.Ouvriere;
import fourmis.role.Reine;

public interface Dessineur {

  public IMovableDrawable dessine(Ouvriere ouvriere);
  public IMovableDrawable dessine(Fourmiliere fourmiliere);

}
