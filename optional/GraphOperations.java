package optional;
import java.util.Random;

/**
 * Class to generate a random graph. If the graph is connected will display an partial tree else the connected components.
 */
public class GraphOperations {
    protected int vertices;
    protected int[][] adjacencyMatrix;
    protected int[][] partialTree;
    protected int adjacencyList[][]; // The adjacency lists for each node 0<= i < vertices from the dfs traverse.

    /**
     * Constructor
     * We created adjency matrix for a directed graph.
     *
     * @param vertices number of vertices in the random graph
     */
    public GraphOperations(int vertices) {
        adjacencyList = new int[vertices][vertices];
        this.vertices = vertices;
        this.partialTree = new int[vertices][vertices];
        adjacencyMatrix = new int[vertices][vertices];
        Random rand = new Random();

        for (int i = 0; i < adjacencyMatrix.length - 1; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (i != j) {
                    adjacencyMatrix[i][j] = rand.nextInt(1000) % 2;
                }
            }
        }
        System.out.println("Adjacency matrix:");
        displayMatrix(adjacencyMatrix);
    }

    /**
     * Display matrix
     * @param matrix adjacency matrix or partial tree.
     */
    public void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    /**
     * Mark the current node as visited and print the node.
     * Traverse all the adjacent and unmarked nodes and call the recursive function with index of adjacent node and a visited array..
     *
     * @param vertex  the start vertex
     * @param visited initialized all the vertices to the flag not visited(in main)
     */
    public void dfs(int vertex, boolean[] visited) {
        if (!visited[vertex]) {
            visited[vertex] = true; // Mark the current node as visited
            System.out.print(vertex + " ");
            // Recur for all the vertices adjacent to this vertex
            for (int neighbour = 0; neighbour < adjacencyMatrix[vertex].length; neighbour++) {
                if (adjacencyMatrix[vertex][neighbour] == 1 && !visited[neighbour]) {
                    partialTree[vertex][neighbour] = 1;//in partial tree exist the edge vertex->neighbour
                    adjacencyList[vertex][neighbour] = 1;
                    dfs(neighbour, visited); // Visit node
                }
            }
        }
    }

    /**
     * Check if the graph is connected using the visited array from the dfs function.
     * The graph is connected if we’ve visited all the vertex, visited[i]=true for any vertex i.
     */
    public boolean isConnected() {
        boolean visited[] = new boolean[vertices];
        System.out.println("Depth-first search:");
        dfs(0, visited);
        System.out.println();
        for (int i = 0; i < visited.length; i++)
            if (visited[i] == false) {
                System.out.println("So... the graph is not connected.");
                return false;
            }
        System.out.println("So... the graph is connected.");
        return true;
    }

    /**
     * Check if the graph is connected. If the graph is connected we have a partial tree, else we have several connected components.
     */
    public void checkConnectivity() {
        if (isConnected())
            displayPartialTree();
        else
            displayConnectedComponents();
    }

    /**
     * We start by initializing all the vertices to the flag not visited, in the array isVisited.
     * We then choose in order vertex to start and check if we’ve visited the vertex or not. If we didn’t, we call the dfs function.
     * In the dfs function, the arguments that we pass are the start vertex and a new array initialized with false.
     * First, we mark the particular input vertex as visited. Then we calculate the adjacent vertices of the given particular input vertex.
     * For each adjacent vertex, we check whether we visited them or not. If not, then we call the dfs function recursively until we mark all the adjacent vertices as visited.
     */
    public void displayConnectedComponents() {
        boolean isVisited[] = new boolean[vertices]; // for dfs call function from connectedComponents
        System.out.println("Connected components:");
        for (int i = 0; i < vertices; i++) {
            dfs(i, isVisited);
            System.out.println();
        }
        System.out.println("Does not exist partial tree because the graph is not connected.");
    }

    /**
     * We display the adjacency matrix of the tree and the parent-children lists for each node.
     */
    public void displayPartialTree() {
        System.out.println("Partial tree:");
        for (int i = 0; i < vertices; i++) {
            if (i == 0)
                System.out.print("root: " + i);
            else
                System.out.print("parent: " + i);
            System.out.print(" children: ");
            for (int j = 0; j < vertices; j++) {
                if (partialTree[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
        System.out.println("The adjacency matrix of the tree:");
        displayMatrix(adjacencyMatrix);
    }
}