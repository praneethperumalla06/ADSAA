import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class Kruskal {

    // Find parent (simple recursion)
    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    // Union of two sets
    static void union(int parent[], int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);
        parent[xParent] = yParent;
    }

    public static void main(String[] args) {

        int V = 4; // vertices
        int E = 5; // edges

        Edge edges[] = new Edge[E];

        // (source, destination, weight)
        edges[0] = new Edge(0, 1, 10);
        edges[1] = new Edge(0, 2, 6);
        edges[2] = new Edge(0, 3, 5);
        edges[3] = new Edge(1, 3, 15);
        edges[4] = new Edge(2, 3, 4);

        // Sort edges by weight (simple bubble sort)
        for (int i = 0; i < E - 1; i++) {
            for (int j = 0; j < E - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }

        int parent[] = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        System.out.println("Minimum Spanning Tree:");

        int count = 0;
        int i = 0;

        while (count < V - 1) {
            Edge next = edges[i++];

            int x = find(parent, next.src);
            int y = find(parent, next.dest);

            if (x != y) { // no cycle
                System.out.println(next.src + " - " + next.dest + " = " + next.weight);
                union(parent, x, y);
                count++;
            }
        }
    }
}
