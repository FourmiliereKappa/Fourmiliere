package Fourmiliere;

import java.util.ArrayList;

import Fourmi.Fourmi;

public class Fourmiliere {
	
	ArrayList<Fourmi> MesFourmis;
	
	public Fourmiliere() {
		MesFourmis = new ArrayList<Fourmi>();
		Thread monthread = new Thread() {
			 public void run() {
				
				while(true) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					appliqueFourmi();
				}
			}
		};
		monthread.run();
		
	}
	
	
	public void nouvelleFourmi() {
		Fourmi maFourmis = new Fourmi(this);
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
