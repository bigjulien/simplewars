package jeu.map;


public class MapException  extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MapException(String s){
        super();
        System.err.println(s);
    }
}
