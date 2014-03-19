package affichage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import map.Map;

public class ChoixUnite extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelchoix = new JPanel(); 
	
	JButton n = new JButton("Chevalier");
	JButton m = new JButton("Archer");
	JButton s = new JButton("Piquier");
	JLabel l = new JLabel("Que veux tu créer ?");
	ChoixUnite()
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
	    this.setLayout(new GridLayout(4,1));
	    this.getContentPane().add(l);
	    this.getContentPane().add(n);	   
	    this.getContentPane().add(m);
	    this.getContentPane().add(s);
	    
	    setVisible(true);
	}
	
	public static void main(String[] yolo) {
	    ChoixUnite f = new ChoixUnite();
	}
	
}
