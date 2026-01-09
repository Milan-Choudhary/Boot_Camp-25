import java.util.*;

public class RottenOranges {
    public static void main(String[] args) {
        
        //problem statement: https://leetcode.com/problems/rotting-oranges/
        //Question: Given a grid where each cell can be empty (0), contain a fresh orange (1), 
        // or contain a rotten orange (2),
        //every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
        //Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
        // If this is impossible, return -1.

        //Example input grid
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        //Desired output: 4

       Queue<int[]> q = new LinkedList<>();
       boolean rot = false;
       for(int i = 0; i<grid.length; i++){
        for(int j = 0; j<grid[0].length; j++){
            if(grid[i][j] == 2){
                q.add(new int[]{i,j});
                rot = true;
            }
        }
       }

       int minute = 0;

       int[] R = {0,1,0,-1};
       int[] C = {1,0,-1,0};


       if(rot == false){
        System.out.println(-1);
       }

       int count = 0;

       while(!q.isEmpty()){

            int length = q.size();
            
            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];
            c = 0;
            
            

            for(int k = 0; k<length; k++){

            for(int i = 0; i<4; i++){
                int a = r + R[i];
                int b = c + C[i];
                if(a >= 0 && b >= 0 && a<grid.length && b<grid[0].length && grid[a][b] == 1){
                    grid[a][b] = 2;
                    q.add(new int[]{a,b});
                    count += 1;
                }
            }
        }

        if(count != 0){
            minute += 1;
        }
                  
    }

       System.out.println(minute);

    }
}
