package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
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
		this.name = name;
		this.monterrain = monterrain;
		affiche = new AfficheRapport(this);
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(800, 600));
		open();
	}
	
	public List<IMovableDrawable> contents() {
		return drawables;
	}

	public void open() {
		
	JFrame frame = new JFrame(name);
	WindowAdapter wa = new WindowAdapter() {
	  public void windowClosing(WindowEvent e) {
		System.exit(0);
	  }
	};

    JMenuBar menubar = new JMenuBar();
    frame.setJMenuBar(menubar);

    JMenu file = new JMenu("File");
    menubar.add(file);

    JMenuItem rapport = new JMenuItem("Rapport");
    rapport.addActionListener(new Rapport());
    file.add(rapport);

	frame.addWindowListener(wa);
	frame.getContentPane().add(this);
	frame.pack();
	frame.setVisible(true);


	}

     public void add(IMovableDrawable d) {
        drawables.add(d);
     }

     public void remove(IMovableDrawable d) {
        drawables.remove(d);
     }

    public void paint(Graphics g) {
        super.paint(g);
        for (Iterator<IMovableDrawable> iter = drawables.iterator(); iter.hasNext();) {
            iter.next().draw(g);
        }
    }

    public void clear() {
        drawables.clear();
     }

    public List<IMovableDrawable> find(Point p) {
        List<IMovableDrawable> l = new ArrayList<IMovableDrawable>();
        for (Iterator<IMovableDrawable> iter = drawables.iterator(); iter.hasNext();) {
        	IMovableDrawable element = iter.next();
            if (element.getBounds().contains(p)) {
                l.add(element);
            }
        }
        return l;
    }

    public class Rapport implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	 affiche.getRapport().trace();
        	 VueRapport vue = new VueRapport();
        	 vue.open();
        }
    }

	@Override
	public void update(Observable o, Object arg) {
		
		this.clear();
		
		for (Dessinable d : monterrain.getDessinable()) {
			this.add(d.getSkin());
		}
		
		this.repaint();
		
	}
	
	public Terrain getTerrain() {
		return monterrain;
	}



}