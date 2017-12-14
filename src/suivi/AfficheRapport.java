package suivi;

import drawing.World;
import monde.Terrain;

public class AfficheRapport {
	
	Terrain leTerrain; // le terrain qu'on regarde pour le rapport
	GestionRapport rapportGestion; // le rapprot de gestion
	
	
	public AfficheRapport(World monworld){
	
		rapportGestion= new GestionRapport(this);
		leTerrain = monworld.getTerrain();

	}
	

	public GestionRapport getRapport() {
		return rapportGestion;
	}
	
	
	public Terrain getTerrain() {
		return leTerrain;
	}


	
}
