//import java.util.*;

public class NoOfIslands {
    public static void main(String[] args){
        
        int[][] grid = {{1,0,1,1,1},
                        {1,1,1,1,0},
                        {0,0,0,0,0},
                        {1,1,1,0,1}};

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int c = 0;


        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j,vis);
                    c += 1;
                }
            }
        }

        System.out.println(c);


    }

    public static void dfs(int[][] grid,int i,int j,boolean[][] vis){

        if(i < 0 || i >= grid.length || j< 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;

        dfs(grid,i+1,j,vis);
        dfs(grid,i, j+1, vis);
        dfs(grid, i-1, j, vis);
        dfs(grid, i, j-1, vis);

    }
}
