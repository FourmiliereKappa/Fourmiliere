package creature;

import drawing.IMovableDrawable;
import monde.Zone;
import monde.theWorld;
import shapeGiver.Dessineur;

public class Puce extends Insecte {


  public Puce(){
    poids = 1;
    theWorld.addCyclable(this);
    theWorld.addDessinable(this);
  }





}
