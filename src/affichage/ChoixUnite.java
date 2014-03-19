package affichage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Controlleur;
import map.Map;

public class ChoixUnite extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelchoix = new JPanel(); 
	Controlleur c;
	JButton n = new JButton("Chevalier");
	JButton m = new JButton("Archer");
	JButton s = new JButton("Piquier");
	JLabel l = new JLabel("Que veux tu créer ?");
	ChoixUnite(Controlleur c)
	{
	    this.setTitle("Choix d'unité");
	    this.setSize(700, 700);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    setResizable(false);
	    n.setFont(new Font(Font.DIALOG, Font.BOLD, 80));
	    m.setFont(new Font(Font.DIALOG, Font.BOLD, 80));
	    s.setFont(new Font(Font.DIALOG, Font.BOLD, 80));
	    l.setFont(new Font(Font.DIALOG, Font.BOLD, 63));
	    n.addMouseListener(new ListenerChoix());
	    m.addMouseListener(new ListenerChoix());
	    s.addMouseListener(new ListenerChoix());
	    this.setLayout(new GridLayout(4,1));
	    this.getContentPane().add(l);
	    this.getContentPane().add(n);	   
	    this.getContentPane().add(m);
	    this.getContentPane().add(s);
	    this.c = c;
	    setVisible(true);
	}
	
	
	
	public static void main(String[] yolo) {
		Controlleur c= new Controlleur();
	    ChoixUnite f = new ChoixUnite(c);
	}
	
	public class ListenerChoix implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) { 
			if(e.getSource()==n)c.creerChevalier(c.getJoueurCourrant());
			else if(e.getSource()==m)c.creerArcher(c.getJoueurCourrant());
			else if(e.getSource()==s)c.creerPiquier(c.getJoueurCourrant());
		}
		@Override
		public void mouseEntered(MouseEvent e) { }
		@Override
		public void mouseExited(MouseEvent e) {	}
		@Override
		public void mousePressed(MouseEvent e) { }
		@Override
		public void mouseReleased(MouseEvent e) { }
	}
	
}