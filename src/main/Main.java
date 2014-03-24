package main;

import map.Map;
import affichage.Frame;
import affichage.PanelCarte;
import affichage.PanelInformations;


/**
 * Classe de lancement du programme
 * @author Benjamin CLAQUIN
 *
 */
public class Main {
    private static final String CONFIGPATH = "Map0";
    
	public static void main(String[] args)
	{
		Map map = new Map(CONFIGPATH);
		
		PanelCarte panelCarte = new PanelCarte(map);
		PanelInformations panelInfo = new PanelInformations();
	    
	    Frame frame = new Frame(map, panelCarte, panelInfo);
	    
	    Controlleur c = new Controlleur(map, frame, panelInfo);
	    
	    panelCarte.setControl(c);
	    panelInfo.setControl(c);
	}
}
