package affichage;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import map.Map;

/**
 * Fenetre principale de jeu
 * 
 * @author Benjamin CLAQUIN
 * 
 */
public class Frame extends JFrame {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private PanelInformations panelInformations;

public Frame(Map map, PanelCarte panelCarte, PanelInformations panelInfo) {
    
    this.setLayout(new BorderLayout());

    setTitle("Simple Wars 0.1");
    setSize(900,600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    setUndecorated(false);
    setBackground(Color.white);


    //panelCarte.setPreferredSize(new Dimension(100,100));
    panelInformations = panelInfo;
    this.add(panelCarte,BorderLayout.CENTER);
    this.add(panelInformations,BorderLayout.EAST);

    
    
    setVisible(true);

    
	}
}
