package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import monde.Terrain;
import shapeGiver.Dessinable;
import suivi.AfficheRapport;


public class World extends JPanel implements Observer{
	
	AfficheRapport affiche;
	private static final long serialVersionUID = 1L;
	private List<IMovableDrawable> drawables = new CopyOnWriteArrayList<IMovableDrawable>(); 
	Terrain monterrain;

	String name = "";

	public World(String name,Terrain monterrain) {
		
		this.name = name; // nom de la fenetre
		this.monterrain = monterrain; // le terrain de la vue
		affiche = new AfficheRapport(this); // ajout de la fenetre de rapport
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(800, 600)); //definition des dimensions et de la couleur
		
		open(); // lancement de l'ouverture de la fenetre
	}
	
	public List<IMovableDrawable> contents() { // recuperation de tout les items
		return drawables;
	}

	public void open() {
		
	JFrame frame = new JFrame(name); // creation de la fenetre
	
	WindowAdapter wa = new WindowAdapter() { //fermeture programme quand fermeture fenetre
	  public void windowClosing(WindowEvent e) {
		System.exit(0);
	  }
	};
	

    JMenuBar menubar = new JMenuBar(); // ajout d'une barre de menu
    frame.setJMenuBar(menubar);

    JMenu file = new JMenu("Vue du rapport"); // ajout à la barre menu de l'option vue du rapport
    menubar.add(file);

    JMenuItem rapport = new JMenuItem("Rapport"); // ajout de l'item à la vue du rapport
    rapport.addActionListener(new Rapport()); // ajout d'un listener au bouton
    file.add(rapport);

	frame.addWindowListener(wa);
	frame.getContentPane().add(this);
	frame.pack();
	frame.setVisible(true);


	}

     public void add(IMovableDrawable d) { // ajout à la liste d'un nouveau item
        drawables.add(d);
     }

     public void remove(IMovableDrawable d) { // remove de la liste un item
        drawables.remove(d);
     }

    public void paint(Graphics g) { // peindre tout les composants 
        super.paint(g);
        for (Iterator<IMovableDrawable> iter = drawables.iterator(); iter.hasNext();) {
            iter.next().draw(g);
        }
    }

    public void clear() { // mis à 0 de la liste
        drawables.clear();
     }

   

    public class Rapport implements ActionListener // Methode pour afficher la vue du rapport
    {
        public void actionPerformed(ActionEvent e)
        {
        	 VueRapport  vue = new VueRapport(affiche);
        	 vue.open();
        	 vue.setText( affiche.getRapport().toString());
        }
    }

	@Override
	public void update(Observable o, Object arg) { // mise à jour de la fenetre
		
		this.clear();
		
		for (Dessinable d : monterrain.getDessinable()) {
			this.add(d.getSkin());
		}
		
		this.repaint();
		
	}
	
	public Terrain getTerrain() {
		return monterrain;
	}

	public World monworld() {
		return this;
	}

}