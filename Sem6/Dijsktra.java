import java.util.*;

class Graph {
    private int V;// Vertex
    private List<List<Node>> adj;// List of list which will contain nodes obj . [ [node1, node2 , node3], [node1 , node2]]
    //   Node has a vertex and a weight                                              index 0               index1
    public Graph(int V) {
        this.V = V;// assign valute to vertex
        adj = new ArrayList<>(V); // assigning a empty list to adj
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>()); // adding V  inner lists to the outer adj list , thus making
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adj.get(source).add(new Node(destination, weight));//directed Graph
        //undirect - add this line - adj.get(destination).add(new Node(source, weight));
    }
    
    //MAIN ALGORITHM    
    public void dijkstra(int startVertex) {
        int[] distance = new int[V];// making distance vertex of size V
        Arrays.fill(distance, Integer.MAX_VALUE);// Assiging inifinity to all nodes , or here max value of integer
        distance[startVertex] = 0;// making distance of source vertex 0

        PriorityQueue<Node> pq = new PriorityQueue<>();// intialising PriorityQueue with type as NODE whose comparator compares weights
        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {//Keep going until heap is not empty
            Node current = pq.poll();//remove element from queue

            for (Node neighbor : adj.get(current.vertex)) {// for loop till till the adj matrix keeps getting neighbours
                int newDist = distance[current.vertex] + neighbor.weight;
                if (newDist < distance[neighbor.vertex]) {//classic dijsktra algo formula
                    distance[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }
        //Printing all the distances
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + distance[i]);
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, weight;
        
        //constructor
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        //Overiding compare to function for implementing PriorityQueue
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 2, 1);

        graph.dijkstra(0);
    }
}
