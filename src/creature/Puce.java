package creature;

import monde.Terrain;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;
import suivi.Report;
import suivi.Trace;

public class Puce extends Ennemi implements Trace {

  public Puce(int x, int y){
	  
    super(x, y); // coordonn�es
    poids = 1.; // d�finition du poids


    Dessineur dessineur = new SkinType1();
    skin = dessineur.dessine(this); // dessin du skin de la puce

    Terrain.addDessinable(this); // ajout du dessinable au Terrain
    
  }

  public void cycle(){
    move(); // la puce bouge � chaque cycle
  }

  @Override
  public void setZone(int x, int y) {
    this.x = x;
    this.y = y;
  }


  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this); // fonction trace sur la puce -> incrementation du nombre de puces
  }

}
