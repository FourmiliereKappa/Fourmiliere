package shapeGiver;

import drawing.IMovableDrawable;
import monde.Zone;

public interface Dessinable {

  public IMovableDrawable accept(Dessineur dessineur);

  public IMovableDrawable getSkin();

  public int getX();

  public int getY();

}
