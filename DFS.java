import java.util.*;

public class DFS {
    public static void main(String[] args) {
        // Implementation of Depth-First Search (DFS) algorithm
        Scanner input = new Scanner(System.in);

        int nodes = input.nextInt();
        int edges = input.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }

        boolean[] visited = new boolean[nodes];
        dfs(0,graph,visited);

        input.close();
    }

    public static void dfs(int node,List<List<Integer>> graph,boolean[] visited){

        visited[node] = true;
        System.out.print(node + "->" + " ");

        for (int neigh : graph.get(node)) {
            if(!visited[neigh]){
                dfs(neigh,graph,visited);
            }
        }

    }
}
