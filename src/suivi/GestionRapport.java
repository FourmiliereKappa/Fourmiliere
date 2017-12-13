package suivi;

public class GestionRapport {

	AfficheRapport rapport;
	
	public GestionRapport(AfficheRapport afficheRapport) {
		this.rapport  = afficheRapport;
	}

	public void trace() {
		Report report = new CountForFourmiliere();
		rapport.getTerrain().trace(report);
		System.out.println(report);

	}

	
}
