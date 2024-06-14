import java.util.*;

public class l02objectsPriorityQueue {
    static class Student implements Comparable<Student> { // for comparing objects IMPLEMEMNT COMPARABLE
        String name;
        int rank;

        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){ // compareTo() -> in order to compare objects
            return this.rank - s2.rank; // compares current object's rank with passed object's rank
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(); // Comparator.reverseOrder()

        pq.add(new Student("B", 4));
        pq.add(new Student("C", 5));
        pq.add(new Student("D", 2)); 
        pq.add(new Student("E", 12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }
    }
}