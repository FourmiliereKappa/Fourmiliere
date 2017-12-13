package creature;

import drawing.IMovableDrawable;
import monde.Terrain;
import monde.Zone;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;

public class Scarabe extends Ennemi {

  public Scarabe(int x, int y){
    super(x, y);
    poids = 100.;


    Dessineur dessineur = new SkinType1();
    skin = dessineur.dessine(this);

    Terrain.addDessinable(this);
  }

  public void cycle(){
    move();
  }

  @Override
  public void setZone(int x, int y) {
    this.x = x;
    this.y = y;
  }




}
