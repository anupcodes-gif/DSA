package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalMST {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class UnionFind {
        int[] parent, rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (rank[rootI] < rank[rootJ]) parent[rootI] = rootJ;
                else if (rank[rootI] > rank[rootJ]) parent[rootJ] = rootI;
                else {
                    parent[rootI] = rootJ;
                    rank[rootJ]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();
        
        addEdge(edges, 0, 1, 10);
        addEdge(edges, 0, 2, 6);
        addEdge(edges, 0, 3, 5);
        addEdge(edges, 1, 3, 15);
        addEdge(edges, 2, 3, 4);

        List<Edge> mst = kruskalMST(V, edges);
        System.out.println("Edges in MST:");
        int totalWeight = 0;
        for (Edge e : mst) {
            System.out.println(e.src + " -- " + e.dest + " == " + e.weight);
            totalWeight += e.weight;
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    private static void addEdge(List<Edge> edges, int s, int d, int w) {
        Edge e = new Edge();
        e.src = s; e.dest = d; e.weight = w;
        edges.add(e);
    }

    public static List<Edge> kruskalMST(int V, List<Edge> edges) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(V);
        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                result.add(e);
                uf.union(e.src, e.dest);
            }
        }
        return result;
    }
}
