package Fourmiliere;

import java.util.ArrayList;

import Fourmi.Fourmi;

public class Fourmiliere {
	
	ArrayList<Fourmi> MesFourmis;
	
	public Fourmiliere() {
		MesFourmis = new ArrayList<Fourmi>();
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
	
	public void newframe() {
		
		for(Fourmi f: MesFourmis) {
			f.cycle(f);
		}
	}
}
