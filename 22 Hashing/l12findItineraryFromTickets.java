import java.util.*;

public class l12findItineraryFromTickets {
    
    public static String getStart(HashMap<String,String> tickets){

        //we will make a reverse hashMap
        HashMap<String,String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key; //starting point
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();

        tickets.put("chennai","bengluru");
        tickets.put("Mumbai","delhi");
        tickets.put("goa","chennai");
        tickets.put("delhi","goa");

        String start = getStart(tickets);

        System.out.print(start); //printing the starting destination
        for(String key : tickets.keySet()){
            System.out.print("-->"+tickets.get(start)); // printing the remaining destinations 
            start = tickets.get(start);
        }
    }
}
