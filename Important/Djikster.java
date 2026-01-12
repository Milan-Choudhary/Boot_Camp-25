package Important;

import java.util.*;

public class Djikster {

    static class Pair{
        int node;
        int dist;
 
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static void  main(String[] args){

    int V = 3; 
    int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
    int src = 2;
    
     ArrayList<ArrayList<Pair>> list = new ArrayList<>();

     for(int i = 0; i<V; i++){
        list.add(new ArrayList<>());
     }

     int[] arr = new int[V];

     Arrays.fill(arr,Integer.MAX_VALUE);

     arr[src] = 0;

     for(int i = 0; i<edges.length; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        int w = edges[i][2];

        list.get(u).add(new Pair(v,w));
        list.get(v).add(new Pair(u,w));

     }

     PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
     pq.add(new Pair(src,0));

     
     while(!pq.isEmpty()){
        Pair cell = pq.poll();
        int dist = cell.dist;
        int node = cell.node;

        if(dist > arr[node]){
            continue;
        }

        for(Pair neigh : list.get(node)){
            int d = neigh.dist;
            int n = neigh.node;

            if(arr[node] + d < arr[n]){
                arr[n] = arr[node] + d;
                pq.add(new Pair(n,arr[n]));
            }


        }

     }

     System.out.println();

     for(int i = 0; i<arr.length; i++){
        System.out.println(i + "node " + + arr[i] + " ");
     }

     

    }
   
}
