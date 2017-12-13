package creature;

import drawing.IMovableDrawable;
import monde.Direction;
import monde.Terrain;
import monde.Zone;
import shapeGiver.Dessineur;
import shapeGiver.Movable;
import shapeGiver.SkinType1;

public abstract class Ennemi implements Cyclable, Movable {

  protected double poids;
  protected int x;
  protected int y;
  protected IMovableDrawable skin;


  public Ennemi(int x, int y){
    setZone(x, y);
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

  public void setZone(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  public double getPoids() {
    return poids;
  }


  public void move(){

    int direction = (int) (Math.random() * 0x4);

    switch(direction){

    case 0:
      Terrain.move(this, Direction.TOP);
      break;
    case 1:
      Terrain.move(this, Direction.LEFT);
      break;
    case 2:
      Terrain.move(this, Direction.DOWN);
      break;
    case 3:
      Terrain.move(this, Direction.RIGHT);

    }
  }


}
