package creature;

import drawing.IMovableDrawable;
import monde.Zone;
import monde.theWorld;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;

public class Puce extends Insecte {


  public Puce(Zone zone){
    super(zone);
    poids = 1;

    Dessineur dessineur = new SkinType1();
    skin = dessineur.dessine(this);

    theWorld.addCyclable(this);
    theWorld.addDessinable(this);
  }

  public void cycle(){
    move();
  }




}
