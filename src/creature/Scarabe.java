package creature;

import monde.Terrain;
import shapeGiver.Dessineur;
import shapeGiver.SkinType1;
import suivi.Report;
import suivi.Trace;

public class Scarabe extends Ennemi implements Trace {

  public Scarabe(int x, int y){
    super(x, y);
    poids = 100.; // d�finition du poids


    Dessineur dessineur = new SkinType1();
    skin = dessineur.dessine(this); // ajout du skin scarabee

    Terrain.addDessinable(this); // ajout du dessinable au terrain
  }

  public void cycle(){
    move(); // � chaque cycle le scarab�e bouge
  }



  @Override
  public void trace(Report r) {
  	r.traceForFourmiliere(this); // fonction trace sur le scarab�e -> incrementation du nombre de scarab�es
  }


}
