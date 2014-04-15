package simplewars.affichage;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Controlleur;



public class ChoixUnite extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelchoix = new JPanel(); 
	Controlleur c;
	JButton n = new JButton("Chevalier");
	JButton m = new JButton("Archer");
	JButton s = new JButton("Piquier");
	JLabel l = new JLabel("Que veux tu creer ?");
	public ChoixUnite(Controlleur c)
	{
	    this.setTitle("Choix d'unité");
	    this.setSize(700, 700);
	    
	    this.setLocationRelativeTo(null);
	    setResizable(false);
	    n.setFont(new Font(Font.DIALOG, Font.BOLD, 80));
	    m.setFont(new Font(Font.DIALOG, Font.BOLD, 80));
	    s.setFont(new Font(Font.DIALOG, Font.BOLD, 80));
	    l.setFont(new Font(Font.DIALOG, Font.BOLD, 63));
	    m.addActionListener(this);
	    s.addActionListener(this);
	    n.addActionListener(this);
	    this.setLayout(new GridLayout(4,1));
	    this.getContentPane().add(l);
	    this.getContentPane().add(n);	   
	    this.getContentPane().add(m);
	    this.getContentPane().add(s);
	    this.c = c;
	    setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == n)
		    c.creerChevalier(c.getJoueurCourant());
		
		else if (arg0.getSource() == m) 
		    c.creerArcher(c.getJoueurCourant());
		
		else if (arg0.getSource() == s) 
		    c.creerPiquier(c.getJoueurCourant());
				
		dispose();
		
	}

	
}
