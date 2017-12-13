package shapeGiver;

import drawing.IMovableDrawable;
import Fourmiliere.Fourmiliere;
import creature.Ennemi;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Soldat;

public interface Dessineur {

  public IMovableDrawable dessine(Ouvriere ouvriere);
  public IMovableDrawable dessine(Fourmiliere fourmiliere);
  public IMovableDrawable dessine(Ennemi ennemi);
}
