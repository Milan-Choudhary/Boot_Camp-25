
import java.util.*;

public class AdjacencyList {
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }

        // Example of adding edges (you can modify this part as needed)
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(2);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(3);

        // Print the adjacency list
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        //Using adjacency matrix
        int matrixSize = input.nextInt();
        int[][] adjMatrix = new int[matrixSize][matrixSize];

        // Example of adding edges (you can modify this part as needed)
        adjMatrix[0][1] = 1;
        adjMatrix[0][2] = 1;
        adjMatrix[1][2] = 1;
        adjMatrix[2][0] = 1;
        adjMatrix[2][3] = 1;
        adjMatrix[3][3] = 1;


        // Print the adjacency matrix
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }



         input.close();

    }

}