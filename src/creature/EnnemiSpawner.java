package creature;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import monde.Zone;
import suivi.Report;

public class EnnemiSpawner {

  Zone zone;
  int x, y;
  List<Ennemi> ennemis = new CopyOnWriteArrayList<Ennemi>(); //sotckage des ennemis présents proche de la fourmilliere



  public EnnemiSpawner(int x, int y){ 
    this.x = x;
    this.y = y;
  }

  public Puce spawnPuce(int x, int y){ //creation ennemie puce
    return new Puce(x, y);
  }

  public Scarabe spawnScarabe(int x, int y){ // creation ennemie scarabée
    return new Scarabe(x, y);
  }

  public void cycle() {
	  
    int randSpawnEnnemi = (int) (Math.random() * 100000) % 1000; // génération aléatoire de la chance qu'un ennemie apparaisse
    
    if (randSpawnEnnemi > 995 && randSpawnEnnemi <999){ // Si puces
    	
      int randX = (int) (Math.random() * 10000) % 400 -200; // generation aléatoire position
      int randY = (int) (Math.random() * 10000) % 400 -200; // generation aléatoire position

      ennemis.add(spawnPuce(randX+x, randY+y));

    }

    if (randSpawnEnnemi == 999){ // Si scarabée
    	
      int randX = (int) (Math.random() * 10000) % 400 -200;
      int randY = (int) (Math.random() * 10000) % 400 -200;

      ennemis.add(spawnScarabe(randX+x, randY+y));

    }

    for(Ennemi ennemi : ennemis){
      ennemi.cycle(); // Lancement du cycle des ennemis
    }

  }

public void trace(Report report) {
	 for(Ennemi ennemi : ennemis){
	      ennemi.trace(report); // compteur pour puces et scarabées
	 }	
}


}
