import java.util.HashMap;
import java.util.Map;

public enum Discipline {

    BUTTERFLY("Butterfly"),
    CRAWL("Crawl"),
    BACKCRAWL("Backcrawl"),
    BREASTSTROKE("Breaststroke");


    private String name;

    Discipline(String name){
        this.name = name;
    }

    //A Map that holds user type name as key.
    private static Map<String,Discipline> userTypeMap = new HashMap<>();

    //Populate userTypeMap with UserType instance
    static{
        for(Discipline type : values()){
            userTypeMap.put(type.name, type);
        }
    }
    public static Discipline of(String name){
        return userTypeMap.get(name);
    }

}
