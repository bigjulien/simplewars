package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Controlleur;
import map.Map;

/**
 * Fenetre principale de jeu
 * 
 * @author Benjamin CLAQUIN
 * 
 */
public class Frame extends JFrame {

private Map map;
private JPanel panelCarte;
private PanelInformations panelInformations;

public Frame(Map map, Controlleur c) {
    
    this.setLayout(new BorderLayout());

    setTitle("Simple Wars 0.1");
    setSize(800,600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    setUndecorated(false);
    setBackground(Color.white);

    panelCarte = new PanelCarte(map,c);
    //panelCarte.setPreferredSize(new Dimension(100,100));
    panelInformations = new PanelInformations();
    panelInformations.setPreferredSize(panelInformations.getDimension());
     this.add(panelCarte,BorderLayout.CENTER);
     this.add(panelInformations,BorderLayout.LINE_END);

    
    
    setVisible(true);

    
	}
}
