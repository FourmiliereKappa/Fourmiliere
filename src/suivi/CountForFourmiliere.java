package suivi;

import Fourmi.Fourmi;
import Fourmi.EtatDev.Adulte;
import Fourmi.EtatDev.Larve;
import Fourmi.EtatDev.Nymphe;
import Fourmi.EtatDev.Oeuf;
import Fourmi.Role.Ouvriere;
import Fourmi.Role.Reine;
import Fourmi.Role.Soldat;
import Fourmiliere.Fourmiliere;

public class CountForFourmiliere implements Report {
	private Integer nombresFourmis;
	private Integer nombresOeufs;
	private Integer nombresLarves;
	private Integer nombresLymphes;
	private Integer nombresAdults;
	private Integer nombresOuvrieres;
	private Integer nombresSoldats;
	private Integer nombresfourmilieres;
	private Integer nombreReine;
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
		// TODO Auto-generated method stub
		this.nombresFourmis++;
	}


	@Override
	public void traceForFourmiliere(Reine reine) {
		// TODO Auto-generated method stub
		this.nombreReine = NBReine;
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

	
	

}
