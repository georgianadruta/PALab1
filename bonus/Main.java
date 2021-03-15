package bonus;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter a number.");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt() && args.length == 0) {
            System.out.println("The number is not an integer! Enter a new number.");
            in.next();
        }
        if (args.length > 0) // It doesn't work properly
            System.err.println("Invalid number  of arguments.");

        int vertices = in.nextInt();

        if (vertices <= 0)
            System.err.println("Cannot create a graph with a negative number of nodes.");

        Tree tree = new Tree(vertices);
        tree.createTree();
    }
}