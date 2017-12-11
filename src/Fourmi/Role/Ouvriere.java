package Fourmi.Role;

import Fourmi.EtatDev.EtatDev;
import creature.Cyclable;
import drawing.IMovableDrawable;
import monde.Direction;
import monde.Zone;
import monde.theWorld;
import shapeGiver.Dessineur;
import shapeGiver.Movable;
import shapeGiver.SkinType1;

public class Ouvriere extends Role implements Movable, Cyclable{

  IMovableDrawable skin;

  public Ouvriere(Zone zone, EtatDev etatDev) {
    super(zone, etatDev);
    Dessineur dessineur = new SkinType1();
    skin = accept(dessineur);
    theWorld.addDessinable(this);
  }

  @Override
  public IMovableDrawable accept(Dessineur dessineur) {
    return dessineur.dessine(this);
  }

  @Override
  public IMovableDrawable getSkin() {
    return skin;
  }

  public void cycle(){
    move();
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
    //System.out.println(direction+ " x: " + getX() + " y: " + getY());
  }

  @Override
  public void setZone(Zone zone){
    this.zone = zone;
  }



}
