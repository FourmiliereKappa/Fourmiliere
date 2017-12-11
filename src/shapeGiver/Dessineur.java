package shapeGiver;

import drawing.IMovableDrawable;
import Fourmiliere.Fourmiliere;
import creature.Insecte;
import creature.Puce;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Soldat;

public interface Dessineur {

  public IMovableDrawable dessine(Ouvriere ouvriere);
  public IMovableDrawable dessine(Fourmiliere fourmiliere);
  public IMovableDrawable dessine(Soldat soldat);
  public IMovableDrawable dessine(Insecte insecte);
  public IMovableDrawable dessine(Puce puce);

}
