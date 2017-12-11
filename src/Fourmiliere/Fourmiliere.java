package Fourmiliere;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Fourmi.Fourmi;

public class Fourmiliere {
	
	List<Fourmi> MesFourmis;
	
	public Fourmiliere() {
		
		MesFourmis = new CopyOnWriteArrayList<Fourmi>();
		
		Thread monthread = new Thread() {
			public void run() {
				 while(true) {
			            try {
			                Thread.sleep(50); // Pause 
			            } catch (InterruptedException ex) {
			                Thread.currentThread().interrupt(); 
			                break; 
			            }
			            for(int i=0;i<20;i++)
			            	appliqueFourmi();
			        }
			}
		};
		monthread.start();
		
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
			f.cycle();
		}
		
	}
}