package map;


public class MapException  extends Exception{

    public MapException(String s){
        super();
        System.err.println(s);
    }
}
