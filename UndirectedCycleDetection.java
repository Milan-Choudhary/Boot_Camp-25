import java.util.*;

public class UndirectedCycleDetection {
    public static void main(String[] args){

        int V = 5;
        int[][] edges = {{1,0},{0,2},{2,3}};
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();


        for(int i = 0; i<V; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[V];
        boolean res = false;
        int parent = -1;

        for(int i = 0; i<V; i++){
            if(!visited[i]){
                res = dfs(i,parent,list,visited);
                if(res == true){
                    break;
                    //return false;
                }
            }
        }

        //return true;
        System.out.println(res);

    }

    public static boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> list,boolean[] visited){
        visited[node] = true;


        for(Integer it : list.get(node)){
            if(!visited[it]){
                if(dfs(it,node,list,visited) == true){// cycle found in deeper call
                    return true;// propagate true upwards
                }
            }
            else if(it != parent){
                return true;
            }
        }

        return false;
    }
}
