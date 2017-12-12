package Fourmi.Role;

import Fourmi.EtatDev.Adulte;
import drawing.IMovableDrawable;
import monde.Direction;
import monde.Terrain;
import shapeGiver.Dessineur;
import shapeGiver.Movable;
import shapeGiver.SkinType1;

public class Soldat extends Role implements Movable{
	
	 Adulte refAdulte=null;
	 IMovableDrawable skin=null;
	 int x,y=0;
	
	  public Soldat(Adulte monAdulte) {
		  
		  System.out.println("Je suis un soldat");
		  refAdulte=monAdulte;
		  Dessineur dessineur = new SkinType1();
		  skin = accept(dessineur);
		  x = 0;
		  y = 0;
		  Terrain.addDessinable(this);
		  
	  }
	
	  
	  public Adulte getAdulte() {
		  return refAdulte;
	  }

	  @Override
	    public IMovableDrawable accept(Dessineur dessineur) {
	    	return dessineur.dessine(this);
	    }

	    @Override
	    public IMovableDrawable getSkin() {
	    	return skin;
	    }

	    public void cycle(){
	    	move();
	    }

	    public void move(){
		  
	    	int direction = (int) (Math.random() * 0x4);

	    	switch(direction){
	    
	    	case 0:
	    		Terrain.move(this, Direction.TOP);
	    		break;
	    	case 1:
	    		Terrain.move(this, Direction.LEFT);
	    		break;
	    	case 2:
	    		Terrain.move(this, Direction.DOWN);
	    		break;
	    	case 3:
	    		Terrain.move(this, Direction.RIGHT);
	        
	    	}
	    }

	    @Override
	    public void setZone(int x,int y){
	    	this.x = x;
	    	this.y = y;
	    }

		@Override
		public int getX() {
			// TODO Auto-generated method stub
			return x;
		}

		@Override
		public int getY() {
			// TODO Auto-generated method stub
			return y;
		}

}
