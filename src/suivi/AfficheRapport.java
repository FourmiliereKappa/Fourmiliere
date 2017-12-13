package suivi;

import drawing.World;
import monde.Terrain;

public class AfficheRapport {
	
	World leMonde;
	Terrain leTerrain;
	GestionRapport rapportGestion;
	
	
	public AfficheRapport(World monworld){
		
		leMonde=monworld;
		System.out.println("constructeur affiche");
		rapportGestion= new GestionRapport(this);
		leTerrain = new Terrain(leMonde);

	}
	

	public GestionRapport getRapport() {
		System.out.println("getRapport");
		return rapportGestion;
	}
	
	
	public Terrain getTerrain() {
		return leTerrain;
	}
}
