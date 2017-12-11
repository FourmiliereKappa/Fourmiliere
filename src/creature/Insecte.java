package creature;

import drawing.IMovableDrawable;
import monde.Direction;
import monde.Zone;
import monde.theWorld;
import shapeGiver.Dessineur;
import shapeGiver.Movable;

public abstract class Insecte implements Cyclable, Movable {

  int poids;
  Zone zone;

  @Override
  public IMovableDrawable accept(Dessineur dessineur) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IMovableDrawable getSkin() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void cycle() {
    // TODO Auto-generated method stub

  }

  @Override
  public void setZone(Zone zone) {
    // TODO Auto-generated method stub

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
