import java.util.*;

public class DirectedCycle {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.get(from).add(to);
        }
        System.out.println(hasCycle(graph) ? "Cycle detected" : "No cycle");

        scanner.close();
        
    }

    public static boolean hasCycle(List<List<Integer>> graph) {
        int vertices = graph.size();
        boolean[] visited = new boolean[vertices];// Track visited nodes
        boolean[] recStack = new boolean[vertices];// Track nodes in the current recursion stack

        for (int i = 0; i < vertices; i++) {
            if (detectCycleUtil(i, visited, recStack, graph)) {
                return true;
            }
        }
        return false;
    }
    private static boolean detectCycleUtil(int v, boolean[] visited, boolean[] recStack, List<List<Integer>> graph) {
        if (recStack[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        recStack[v] = true;

        for (Integer neighbor : graph.get(v)) {
            if (detectCycleUtil(neighbor, visited, recStack, graph)) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }
}
