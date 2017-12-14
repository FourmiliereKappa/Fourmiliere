package suivi;

public class GestionRapport {

	AfficheRapport rapport;
	
	public GestionRapport(AfficheRapport afficheRapport) {
		this.rapport  = afficheRapport;
	}

	public void trace() {
		Report report = new CountForFourmiliere(); // création du compteur
		rapport.getTerrain().trace(report); // lancement du comptage à partir du terrain
		System.out.println(report);

	}
	
	public String toString() { // redéfinition pour affichage
		Report report = new CountForFourmiliere();
		rapport.getTerrain().trace(report);
		return report.toString();
	}

	
}
