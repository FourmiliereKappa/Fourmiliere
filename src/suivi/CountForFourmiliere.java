package suivi;

import Depot.Cadavre;
import Depot.Depot;
import Fourmi.Fourmi;
import Fourmi.EtatDev.Adulte;
import Fourmi.EtatDev.Larve;
import Fourmi.EtatDev.Nymphe;
import Fourmi.EtatDev.Oeuf;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Reine;
import Fourmi.Role.Soldat;
import Fourmiliere.Fourmiliere;
import creature.Ennemi;
import creature.Puce;
import creature.Scarabe;
import monde.Terrain;

public class CountForFourmiliere implements Report { // tout les compteurs pour les fourmis
	private Integer nombresFourmis;
	private Integer nombresOeufs;
	private Integer nombresLarves;
	private Integer nombresLymphes;
	private Integer nombresAdults;
	private Integer nombresOuvrieres;
	private Integer nombresSoldats;
	private Integer nombresfourmilieres;
	private Integer nombreReine;
	private Integer nombresPuces;
	private Integer nombresScarabes;
	private Integer nombresCadavres;
	static int NBReine = 1;
	
	
	public CountForFourmiliere() {
		this.nombresFourmis = new Integer(0);
		this.nombresOeufs = new Integer(0);
		this.nombresLarves = new Integer(0);
		this.nombresLymphes = new Integer(0);
		this.nombresAdults = new Integer(0);
		this.nombresOuvrieres = new Integer(0);
		this.nombresSoldats = new Integer(0);
		this.nombresfourmilieres = new Integer(0);
		this.nombreReine = new Integer(0);
		this.nombresPuces = new Integer(0);
		this.nombresScarabes = new Integer(0);
		this.nombresCadavres = new Integer(0);
	}


	@Override
	public void traceForFourmiliere(Soldat soldat) {
		// TODO Auto-generated method stub
		this.nombresSoldats++;
	}


	@Override
	public void traceForFourmiliere(Fourmiliere fourmiliere) {
		// TODO Auto-generated method stub
		this.nombresfourmilieres++;
	}


	@Override
	public void traceForFourmiliere(Fourmi fourmi) {
		this.nombresFourmis++;
	}


	@Override
	public void traceForFourmiliere(Reine reine) {
		// TODO Auto-generated method stub
		this.nombreReine ++;
	}


	@Override
	public void traceForFourmiliere(Larve larve) {
		// TODO Auto-generated method stub
		this.nombresLarves++;
	}


	@Override
	public void traceForFourmiliere(Oeuf oeuf) {
		// TODO Auto-generated method stub
		this.nombresOeufs++;
	}


	@Override
	public void traceForFourmiliere(Adulte adulte) {
		// TODO Auto-generated method stub
		this.nombresAdults++;
	}


	@Override
	public void traceForFourmiliere(Nymphe lymphe) {
		// TODO Auto-generated method stub
		this.nombresLymphes++;
	}


	@Override
	public void traceForFourmiliere(Ouvriere ouvriere) {
		// TODO Auto-generated method stub
		this.nombresOuvrieres++;
	}

	@Override
	public void traceForFourmiliere(Puce puce) {
		// TODO Auto-generated method stub
		this.nombresPuces++;
	}

	@Override
	public void traceForFourmiliere(Scarabe scarabe) {
		// TODO Auto-generated method stub
		this.nombresScarabes++;
	}
	
	
	@Override
	public String toString() {
		String CountFourmiliere = "Rapport de la fourmiliere : \n";
		CountFourmiliere += "Nombres de Fourmilieres : " + nombresfourmilieres + "\n";
		CountFourmiliere += "Nombres de Fourmis : " + nombresFourmis + "\n";
		CountFourmiliere += "Nombres de Oeufs : " + nombresOeufs + "\n";
		CountFourmiliere += "Nombres de Larves : " + nombresLarves + "\n";
		CountFourmiliere += "Nombres de Lymphes : " + nombresLymphes + "\n";
		CountFourmiliere += "Nombres d'Adultes : " + nombresAdults + "\n";
		CountFourmiliere += "Nombres d'Ouvrieres : " + nombresOuvrieres + "\n";
		CountFourmiliere += "Nombres de Soldats : " + nombresSoldats + "\n";
		CountFourmiliere += "Nombre de Reine : " + nombreReine + "\n";
		CountFourmiliere += "Nombres de Puces : " + nombresPuces + "\n";
		CountFourmiliere += "Nombres de Scarabes : " + nombresScarabes + "\n";
		CountFourmiliere += "Nombres de Cadavres : " + nombresCadavres + "\n";
		return CountFourmiliere;
	}


	@Override
	public void traceForFourmiliere(Terrain terrain) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void traceForFourmiliere(Ennemi ennemi) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void traceForFourmiliere(Depot depot) {
				
	}


	@Override
	public void traceForFourmiliere(Cadavre cadavre) {
		this.nombresCadavres++;		
	}
	

}
