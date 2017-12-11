package monde;

import java.util.ArrayList;
import java.util.List;

import shapeGiver.Dessinable;

public class Zone {

  private List<Dessinable> dessinables;
  private final int x;
  private final int y;

  public Zone(int x, int y){
    dessinables = new ArrayList<Dessinable>();
    this.x = x;
    this.y = y;
  }

  public void remove(Dessinable dessinable){
    dessinables.remove(dessinable);
  }

  public void add(Dessinable dessinable){
    dessinables.add(dessinable);
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

}
