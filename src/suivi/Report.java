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
import monde.Terrain;

public interface Report {
	
	void traceForFourmiliere(Soldat soldat);
	
	void traceForFourmiliere(Fourmiliere fourmiliere);

	void traceForFourmiliere(Fourmi fourmi);
	
	void traceForFourmiliere(Reine reine);

	void traceForFourmiliere(Larve larve);	

	void traceForFourmiliere(Oeuf oeuf);
	
	void traceForFourmiliere(Adulte adulte);

	void traceForFourmiliere(Nymphe lymphe);

	void traceForFourmiliere(Ouvriere ouvriere);

	void traceForFourmiliere(Terrain terrain);
	

}
