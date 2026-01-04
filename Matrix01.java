import java.util.*;

public class Matrix01 {
    public static void main(String[] args){

        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};

        int[][] grid = new int[matrix.length][matrix[0].length];

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int[] R ={0,1,0,-1}; 
        int[] C ={1,0,-1,0};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int a = cell[0];
            int b = cell[1];

            for(int i = 0; i<4; i++){
                int r = a + R[i];
                int c = b + C[i];

                if(r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && !visited[r][c]){
                    grid[r][c] = grid[a][b] + 1;
                    q.add(new int[]{r,c});
                    visited[r][c] = true;
                }
            }

        }

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
}

}
