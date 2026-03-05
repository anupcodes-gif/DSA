package graphs;

import java.util.Arrays;

public class BellmanFord {
    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s; dest = d; weight = w;
        }
    }

    public void solve(int V, int E, Edge[] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (int j = 0; j < E; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int weight = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Negative cycle detected");
                return;
            }
        }

        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        Edge[] edges = new Edge[E];
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        BellmanFord bf = new BellmanFord();
        bf.solve(V, E, edges, 0);
    }
}
