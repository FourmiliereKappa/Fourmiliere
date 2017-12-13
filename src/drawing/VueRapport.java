package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import drawing.World.Rapport;
import suivi.AfficheRapport;

public class VueRapport extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AfficheRapport affiche;
	TextArea label;
	
	public VueRapport(AfficheRapport affiche) {

		this.affiche=affiche;
		label = new TextArea("rapport");
		label.setEditable(false);
		label.setPreferredSize(new Dimension(300, 600));
		this.setBackground(Color.WHITE);
		
	}
	
	
	public void open() {
	    String name = "Rapport Fourmis";
		JFrame frame = new JFrame(name);
		

	    JMenuBar menubar = new JMenuBar();
	    frame.setJMenuBar(menubar);

	    JMenu file = new JMenu("refresh Rapport");
	    menubar.add(file);

	    JMenuItem rapport = new JMenuItem("refresh");
	    rapport.addActionListener(new Rapport());
	    file.add(rapport);

		frame.getContentPane().add(this);
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
		}
	
	 public class Rapport implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	 setText( affiche.getRapport().toString());
	        }
	    }
	
	public void setText(String text) {
		label.setText(text);
	}
	
}
