package creature;

import monde.Terrain;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;
import suivi.Report;
import suivi.Trace;

public class Puce extends Ennemi implements Trace {

  public Puce(int x, int y){
	  
    super(x, y);
    poids = 1.;


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


  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this);
  }

}
