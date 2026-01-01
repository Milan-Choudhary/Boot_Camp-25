import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{5,2},{5,0},{4,0},{4,1},{2,3},{3,1}};
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i<V; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
        }

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i = 0; i<V; i++){
            if(!visited[i]){
                dfs(i,list,st,visited);
            }  
        }
        

        while(!st.isEmpty()){
            System.out.print(st.pop() + "->");
        }

    }

    public static void dfs(int node,ArrayList<ArrayList<Integer>> list,Stack<Integer> st,boolean[] visited){

        visited[node] = true;

        for(int neigh : list.get(node)){
            if(!visited[neigh]){
                dfs(neigh, list,st, visited);
            }
        }

        st.push(node);

    }
}
