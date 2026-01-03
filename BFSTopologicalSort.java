import java.util.*;

public class BFSTopologicalSort {
    public static void main(String[] args){
        int v = 7;
        int[][] edges = {{0,1},{1,2},{1,3},{2,4},{2,5},{2,6},{3,6},{4,5},{5,6}};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i<v; i++){
            list.add(new ArrayList<>());
        }

        int[] degree = new int[v];
        for(int i = 0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            degree[edges[i][1]] += 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<v; i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){

            int p = q.poll();
            res.add(p);

            for(int neigh : list.get(p)){
                degree[neigh] -= 1;
                if(degree[neigh] == 0){
                    q.add(neigh);
                }
            }

        }

        for(int i = 0; i<res.size(); i++){
            System.out.println(res.get(i));
        }

        
        
        
    }
}
