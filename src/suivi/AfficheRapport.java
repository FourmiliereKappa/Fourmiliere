package suivi;

import drawing.World;
import monde.Terrain;

public class AfficheRapport {
	
	World leMonde;
	Terrain leTerrain;
	GestionRapport rapportGestion;
	
	
	public AfficheRapport(World monworld){
	
		rapportGestion= new GestionRapport(this);
		leTerrain = monworld.getTerrain();

	}
	

	public GestionRapport getRapport() {
		System.out.println("getRapport");
		return rapportGestion;
	}
	
	
	public Terrain getTerrain() {
		return leTerrain;
	}
}
