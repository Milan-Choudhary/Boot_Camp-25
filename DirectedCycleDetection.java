import java.util.*;

public class DirectedCycleDetection {
    public static void main(String[] args){
        int V = 4;
        int[][] edges = {{0,1},{1,2},{2,3},{3,0}};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i<V; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
        }

        
    }
}
