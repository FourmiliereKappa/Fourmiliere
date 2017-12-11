package creature;

import drawing.IMovableDrawable;
import monde.Direction;
import monde.Zone;
import monde.theWorld;
import shapeGiver.Dessineur;
import shapeGiver.Movable;
import shapeGiver.SkinType1;

public abstract class Insecte implements Cyclable, Movable {

  int poids;
  Zone zone;
  IMovableDrawable skin;

  public Insecte(Zone zone){
    this.zone = zone;

  }

  @Override
  public IMovableDrawable accept(Dessineur dessineur) {
    return dessineur.dessine(this);
  }

  @Override
  public IMovableDrawable getSkin() {
    return skin;
  }

  @Override
  public void cycle() {

  }

  @Override
  public void setZone(Zone zone) {
    this.zone = zone;

  }

  @Override
  public int getX() {
    return zone.getX();
  }

  @Override
  public int getY() {
    return zone.getY();
  }

  public void move(){
    int direction = (int) (Math.random() * 0x4);

    switch(direction){
      case 0:
        theWorld.move(this, Direction.TOP);
        break;
      case 1:
        theWorld.move(this, Direction.LEFT);
        break;
      case 2:
        theWorld.move(this, Direction.DOWN);
        break;
      case 3:
        theWorld.move(this, Direction.RIGHT);
    }
  }


}
