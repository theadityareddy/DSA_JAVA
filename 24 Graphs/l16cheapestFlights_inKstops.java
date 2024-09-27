import java.util.*;

public class l16cheapestFlights_inKstops {

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

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dst = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dst, wt);

            graph[src].add(e);
        }
    }

    static class Info {
        int v; // vertex
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    @SuppressWarnings("unchecked")
    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {

        // creating graph
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        // intialing all dist by infinity in dist array
        int dist[] = new int[n];
        for (int i = 0; i < dist.length; i++) { 
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // start

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // if greater than req stops
            if (curr.stops > k) {
                break;
            }

            // for neighbours
            for (int i = 0; i < graph[curr.v].size(); i++) {

                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // relaxation
                if (curr.cost + wt <= dist[v] && curr.stops <= k) { // dist[u] == curr.cost
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1; // if distance is not fonud
        } else {
            return dist[dest];
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 0, 100 },
                { 1, 3, 600 },
                { 2, 3, 200 } };
        int src = 0, dst = 3, k = 1;

        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        System.out.print(cheapestFlight(n, flights, src, dst, k) + "\n");
    }
}