package creature;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Fourmi;
import monde.Zone;

public class EnnemiSpawner implements Cyclable{

  Zone zone;
  int x, y;
  List<Ennemi> ennemis = new CopyOnWriteArrayList<Ennemi>();



  public EnnemiSpawner(int x, int y){
    this.x = x;
    this.y = y;
  }

  public Puce spawnPuce(int x, int y){
    return new Puce(x, y);
  }

  public Scarabe spawnScarabe(int x, int y){
    return new Scarabe(x, y);
  }

  @Override
  public void cycle() {
    int randSpawnEnnemi = (int) (Math.random() * 100000) % 1000;
    //System.out.println("rand : "+randSpawnPuce);
    if (randSpawnEnnemi > 995 && randSpawnEnnemi <999){
      int randX = (int) (Math.random() * 10000) % 400 -200;
      int randY = (int) (Math.random() * 10000) % 400 -200;

      ennemis.add(spawnPuce(randX+x, randY+y));
  
    }

    if (randSpawnEnnemi == 999){
      int randX = (int) (Math.random() * 10000) % 400 -200;
      int randY = (int) (Math.random() * 10000) % 400 -200;

      ennemis.add(spawnScarabe(randX+x, randY+y));

      
    }

    for(Ennemi ennemi : ennemis){
      ennemi.cycle();
    }

  }


}
