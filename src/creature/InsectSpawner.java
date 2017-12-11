package creature;

import monde.Zone;
import monde.theWorld;

public class InsectSpawner implements Cyclable{

  Zone zone;

  public InsectSpawner(){
    zone = new Zone(0, 0);
    theWorld.addCyclable(this);
  }

  public void spawnPuce(){
    int randX = (int) (Math.random() * 10000) % 400 -200;
    int randY = (int) (Math.random() * 10000) % 400 -200;
    new Puce(new Zone(zone.getX()+randX, zone.getY()+randY));
  }

  @Override
  public void cycle() {
    int randSpawnPuce = (int) (Math.random() * 10000) % 100;
    //System.out.println("rand : "+randSpawnPuce);
    if (randSpawnPuce > 95){
      spawnPuce();
    }

  }


}
