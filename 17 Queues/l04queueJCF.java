import java.util.*;

public class l04queueJCF {
    public static void main(String[] args) {
        // Queue is an interface and not a class, we cannot create objects of interfaces
        Queue <Integer> q = new LinkedList<>(); // Queue can be made with either LinkedList class or ArrayDeque class
        // Queue <Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(3);
        q.add(5);
        System.out.println("removed: " + q.remove());
        q.add(7);
        System.out.println("removed: " + q.remove());
        q.add(9);
        
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
