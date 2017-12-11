package monde;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import creature.Cyclable;
import drawing.World;
import shapeGiver.Dessinable;
import shapeGiver.Movable;

public class theWorld {

  static private List<Cyclable> reines = new ArrayList<Cyclable>();
  static private List<Cyclable> cyclables = new CopyOnWriteArrayList<Cyclable>();
  static private List<Dessinable> dessinables = new ArrayList<Dessinable>();
  static private Hashtable<Integer, Hashtable<Integer, Zone>> zones= new Hashtable<Integer, Hashtable<Integer, Zone>>();
  static private World world;

  public static void setWorld(World newWorld){
    world = newWorld;
  }

  public static void addDessinable(Dessinable dessinable){
    world.add(dessinable.getSkin());
    dessinables.add(dessinable);
  }

  public static void removeDessinable(Dessinable dessinable){
    world.remove(dessinable.getSkin());
    dessinables.remove(dessinable);
  }

  public static void addCyclable(Cyclable cyclable){
    cyclables.add(cyclable);
  }

  public static void addQueen(Cyclable cyclable){
    reines.add(cyclable);
  }


  public static void cycle(){
    for (Cyclable cyclable: cyclables){
      cyclable.cycle();
      System.out.println(cyclable.toString());
    }
    System.out.println(cyclables.size());
    for (Dessinable dessinable : dessinables){
      dessinable.getSkin().setPosition(new Point(dessinable.getX()+400, dessinable.getY()+300));
    }
  }

  public static void move(Movable movable, Direction direction){
    switch (direction){
      case TOP:
        movable.setZone(getZone(movable.getX(), movable.getY()-1));
        getZone(movable.getX(), movable.getY()+1).remove(movable);
        break;
      case LEFT:
        movable.setZone(getZone(movable.getX()-1, movable.getY()));
        getZone(movable.getX()+1, movable.getY()).remove(movable);
        break;
      case DOWN:
        movable.setZone(getZone(movable.getX(), movable.getY()+1));
        getZone(movable.getX(), movable.getY()-1).remove(movable);
        break;
      case RIGHT:
        movable.setZone(getZone(movable.getX()+1, movable.getY()));
        getZone(movable.getX()-1, movable.getY()).remove(movable);
        break;
    }
  }

  public static Zone getZone(int x, int y){
    if(zones.get(x) == null){
      zones.put(x, (new Hashtable<Integer, Zone>()));
    }
    if(zones.get(x).get(y) == null){
      zones.get(x).put(y, new Zone(x, y));
    }
    return zones.get(x).get(y);
  }

  public static List<Dessinable> getDessinables(){
    return dessinables;
  }

}
