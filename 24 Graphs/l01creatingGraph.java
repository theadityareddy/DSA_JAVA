import java.util.*;

public class l01creatingGraph {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {

        int v = 5; // no. of vertices
        ArrayList<Edge>[] graph = new ArrayList[v];

        // null -> creating empty Arraylist
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // at 0-vertex
        graph[0].add(new Edge(0, 1, 5));

        // at 1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // at 2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // at 3-vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // at 4-vertex
        graph[4].add(new Edge(4, 2, 2));

        // printing the neighbours (2nd vertex)f
        for(int i =0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest + " " + e.wt);
        }
    }
}