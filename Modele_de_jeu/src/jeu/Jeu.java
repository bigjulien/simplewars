package jeu;

import javax.swing.*;

import ressources.Audio;
import ressources.Maps;
import simplewars.affichage.PanelCarte;
import simplewars.affichage.PanelInformations;
import simplewars.map.Map;
import simplewars.map.MapReader;

import devintAPI.FenetreAbstraite;
import devintAPI.Preferences;

import java.awt.*;
import java.awt.event.*;

/** Cette classe est un exemple d'interface de jeu.
 *  Elle étend DevintFrame pour avoir un Frame et réagir aux évênements claviers
 * Implémente ActionListener pour réagir au clic souris sur le bouton.
 * On surchage la méthode "keyPressed" pour associer une action à la touche F3
 * 
 * @author helene
 *
 */

public class Jeu extends FenetreAbstraite implements ActionListener{

	// le bouton pour la question
	// est une variable d'instance car il doit être accessible 
	// dans la méthode actionPerformed 
	private JButton question;
	
	// un label
	// est une variable d'instance car il doit être accessible 
	// dans la méthode changeColor, qui gère les préférences
	private JTextArea lb1;
	
	// appel au constructeur de la classe mère
    public Jeu(String title) {
    	super(title);
    	
    	int iMap = 0;
    	
		boolean musique = true;

	    MapReader mapReader = new MapReader();
		Map map = mapReader.readMap(Maps.getMap(iMap));
		
		PanelCarte panelCarte = new PanelCarte(map);
		PanelInformations panelInfo = new PanelInformations();
	    	    
	    Controlleur c = new Controlleur(map, this, panelInfo);
	    
	    panelCarte.setControl(c);
	    panelInfo.setControl(c);
	    
	    if (musique) {
	        Audio.musiqueAmbiante();
	    }
        this.setLayout(new BorderLayout());

        setBackground(Color.white);

        //panelCarte.setPreferredSize(new Dimension(100,100));
        this.add(panelCarte,BorderLayout.CENTER);
        this.add(panelInfo,BorderLayout.EAST);
        
        setVisible(true);
     }
    
	// renvoie le fichier wave contenant le message d'accueil
	protected  String wavAccueil() {
		return "../ressources/sons/accueil.wav";
	}
	
	// renvoie le fichier wave contenant la règle du jeu
	protected  String wavRegleJeu() {
		return "../ressources/sons/aideF1.wav";
	}
	
	// renvoie le fichier wave contenant la règle du jeu
	protected  String wavAide() {
		return Audio.AIDE;
	}

    // définition de la méthode abstraite "init()"
    // initialise le frame 
    protected void init() {
    	
   }

    // lire la question si clic sur le bouton 
    public void actionPerformed(ActionEvent ae){
       	// toujours stopper la voix avant de parler
    	voix.stop();
    	// on récupère la source de l'évènement
     	Object source = ae.getSource();
     	// si c'est le bouton "question" on lit la question
     	// le contenu des questions est variable donc on les lit avec SI_VOX
    	if (source.equals(question)) {
    		String text = "les questions sont longues et ont un contenu variable.";
    		text += "Il ne faut pas générer un fichier wave mais lire directement les textes";
    		voix.playText(text);
    	}	
    	// on redonne le focus au JFrame principal 
    	// (après un clic, le focus est sur le bouton)
    	this.requestFocus();
    }
 
    // évènements clavier
    public void keyPressed(KeyEvent e) {
    	// appel à la méthode mère qui gère les évènements ESC, F1, F3, F4
    	super.keyPressed(e);
    	// cas particulier pour ce jeu : la touche F5
    	if (e.getKeyCode()==KeyEvent.VK_F5){
    	   	voix.playText("Vous venez d'appuyer sur EFFE 5");
    	}
    }
    
	/**
	 * Pour modifier les couleurs de fond et de premier plan de la fenêtre
	 * Cette fonction est appelée par la fonction "changeColor" de la classe "Preferences"
	 * à chaque fois que l'on presse F3 
	 * 
	 * on change la couleur du texte principal
	 **/
	public  void changeColor() {
    	// on récupère les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		lb1.setBackground(pref.getCurrentBackgroundColor());
		lb1.setForeground(pref.getCurrentForegroundColor());
	}

}
