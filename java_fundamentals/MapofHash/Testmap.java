import java.util.HashMap;
import java.util.Set;
public class Testmap{
    public static void main(String[] args){
    HashMap<String, String> users = new HashMap<String, String>();
    users.put("A$ap Rocky", "Praise the lord");
    users.put("Drake", "Jumpman");
    users.put("Jcole", "2 talez");
    users.put("Sheck Wes", "Mo Bomba");

    String name = users.get("Jcole");

    Set<String> keys = users.keySet();
        for(String key : keys){
            System.out.printf("%s - %s\n", key,users.get(key));
        }
    }
}