package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import suivi.AfficheRapport;

public class VueRapport extends JPanel{

	
	private static final long serialVersionUID = 1L;
	AfficheRapport affiche;
	TextArea label;
	
	public VueRapport(AfficheRapport affiche) {

		this.affiche=affiche;
		label = new TextArea("rapport"); //affichage des données du rapport
		label.setEditable(false); // non éditable car juste affichage
		label.setPreferredSize(new Dimension(300, 600)); // définition de la taille de textArea
		this.setBackground(Color.WHITE);
		
	}
	
	
	public void open() {
		
	    String name = "Rapport Fourmis";
		JFrame frame = new JFrame(name); // creation de la fenetre
		

	    JMenuBar menubar = new JMenuBar(); // ajout d'une barre de menu
	    frame.setJMenuBar(menubar);

	    JMenu file = new JMenu("refresh Rapport"); // ajout du menu pour refresh
	    menubar.add(file);

	    JMenuItem rapport = new JMenuItem("refresh"); // ajout de l'item refresh
	    rapport.addActionListener(new Rapport()); // si on appuie sur le bouton on lance le rapport
	    file.add(rapport);

		frame.getContentPane().add(this);
		frame.add(label);
		frame.pack();
		frame.setVisible(true); // affichage 
		
		}
	
	 public class Rapport implements ActionListener // Lancement du refresh
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	 setText( affiche.getRapport().toString());
	        }
	    }
	
	public void setText(String text) { // modif du texte de la textarea
		label.setText(text);
	}
	
}
