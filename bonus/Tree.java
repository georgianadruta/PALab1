package bonus;
import java.util.ArrayList;
import java.util.List;

import optional.GraphOperations;

/**
 * Class to generate a rooted tree with root=0 from a random graph if the graph is connected.
 */
public class Tree extends GraphOperations {
    // An ArrayList of ArrayList, the adjacency list for each node.
    private List<ArrayList<Integer>> partialTree = new ArrayList<ArrayList<Integer>>(vertices);

    /**
     * Constructor
     * We created adjacency matrix for an directed graph.
     *
     * @param vertices number of vertices in the random graph
     */
    public Tree(int vertices) {
        super(vertices);
    }

    /**
     *  A function to add a new node to adjacency list for the current node i if exist an edge between the nodes i and j
     */
    public void addEdge() {
        for (int i = 0; i < adjacencyList.length; i++) {
            ArrayList<Integer> inner = new ArrayList<Integer>(vertices);
            for (int j = 0; j < adjacencyList.length; j++) {
                if (adjacencyList[i][j] == 1) {
                    inner.add(j);
                }
            }
            partialTree.add(inner);
        }
    }

    /**
     * Print the adjacency lists from dfs
     */
    public void printAdjacencyLists() {
        System.out.println("Adjacency lists: ");
        for (int i = 0; i < partialTree.size(); i++) {
            System.out.print("\nAdjacency list of vertex " + i + ": ");
            for (int j = 0; j < partialTree.get(i).size(); j++) {
                System.out.print(partialTree.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    /**
     * We created adjacency lists and print them, then create the tree with their help (see function tree).
     */
    public void createTree() {
        if (isConnected() == true) { // The graph is connected.
            addEdge();
            printAdjacencyLists();
            printTree();
        } else {
            System.out.println("Does not exist a tree because the graph is not connected.");
        }
    }

    /**
     * It starts with the root=0 and goes trough every son the root has, every son each son of the root has and so on until it traversed the all adjacency lists(count=vertices).
     * If the current node is a left node it prints "-", otherwise it prints "+".
     */
    public void printTree() {
        int currentNode = 0; // the root is 0.
        System.out.println("Tree representation:\n+node0");
        int count = 0, k = -1;
        int[] order = new int[vertices]; // Traverse the tree in level order.
        order[0] = 0; // Add the root.
        while (count < vertices) { // We need to add all the nodes in the tree.
            currentNode = order[++k];
            for (int i = 0; i < partialTree.get(currentNode).size(); i++) {
                // Traverse an ArrayList of ArrayList, adjacency list for each node i.
                order[++count] = partialTree.get(currentNode).get(i); // Add the new node in tree.
                int sum = 0;
                for (int j = 0; j < vertices; j++) {
                    // Number of adjacent nodes with the current node from tree
                    sum += adjacencyList[partialTree.get(currentNode).get(i)][j];
                }
                if (sum > 0) // I couldn't make it work... partialTree.get(currentNode)!=null
                    System.out.print("  +node" + partialTree.get(currentNode).get(i)); // If the current node is not a leaf "+".
                else
                    System.out.print("  -node" + partialTree.get(currentNode).get(i)); // If the current node is a leaf "-".
            }
            System.out.println();
        }
    }
}
