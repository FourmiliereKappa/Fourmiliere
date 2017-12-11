package Fourmiliere;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Fourmi;
import Fourmi.EtatDev.Oeuf;

public class Fourmiliere {
	
	CopyOnWriteArrayList<Fourmi> MesFourmis;
	
	public Fourmiliere() {
		
		MesFourmis = new CopyOnWriteArrayList<Fourmi>();
		Thread monthread = new Thread() {
			 public void run() {
				
				while(true) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int i=0;
					while(i<20) {
						appliqueFourmi();
						i++;
					}

				}
			}
		};
		monthread.run();
		
	}
	
	
	public void nouvelleFourmi() {
		Fourmi maFourmis = new Fourmi(this, new Oeuf());
		putFourmi(maFourmis);
	}
	

	
	public void putFourmi(Fourmi manouvelleFourmi) {
		MesFourmis.add(manouvelleFourmi);
	}
	
	
	public void removeFourmi(Fourmi maFourmieffacer) {
		MesFourmis.remove(maFourmieffacer);
	}
	
	public void appliqueFourmi() {
		
		for(Fourmi f: MesFourmis) {
			f.cycle(f);
		}
	}
}