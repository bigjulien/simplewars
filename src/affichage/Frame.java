package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import map.Map;

/**
 * Fenetre principale de jeu
 * @author Benjamin CLAQUIN
 *
 */
public class Frame extends JFrame{

 private Map map;
 private JPanel panelCarte;
 private JPanel panelInformations;
 
 public Frame(Map map) {
     
     this.map=map;
     
     this.setLayout(new BorderLayout());
     
     this.setTitle("Simple Wars 0.1");
     
     this.setLocationRelativeTo(null);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setResizable(false);
     this.setUndecorated(false);
     this.setBackground(Color.white);
     
     panelCarte = new PanelCarte(map);
     panelInformations = new PanelInformations();
     
     this.add(panelCarte);
     this.add(panelInformations);
     
     
     this.pack();
     this.setVisible(true);
     

 }



}
