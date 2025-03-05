import java.util.*;

class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    // Constructor to initialize the graph
    public Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // BFS Algorithm
    public void BFS(int start) {
        boolean[] visited = new boolean[V]; // Visited array
        Queue<Integer> queue = new LinkedList<>(); // Using Queue

        visited[start] = true; // Mark the start node as visited
        queue.add(start); // Enqueue start node

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Dequeue a node
            System.out.print(node + " "); // Process node

            // Iterate over all adjacent nodes
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark visited
                    queue.add(neighbor); // Enqueue neighbor
                }
            }
        }
    }
}   
public class Main{
    // Main method to test the BFS
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1,2);
        g.addEdge(2,5);
        g.addEdge(5, 3);
        g.addEdge(3, 4);
        // g.addEdge(3, 5);
        // g.addEdge(4, 5);

        System.out.println("Breadth-First Search (BFS) starting from node 0:");
        g.BFS(0);
    }
}
