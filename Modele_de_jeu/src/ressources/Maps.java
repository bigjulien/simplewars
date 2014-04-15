package ressources;

public class Maps {
	private static final String MP = Ressources.RESS + "maps/";
	private static final String[] MAPS = { "Map0" };
	
	public static String getMap(int i) {
		return MP + MAPS[i];
	}
	
	public static int getNbMaps() {
		return MAPS.length;
	}
}
