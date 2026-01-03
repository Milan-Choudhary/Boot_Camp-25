import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        if (n == 1 && m == 1) return 1;

        boolean[][] visited = new boolean[n][m];
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        Queue<int[]> q = new LinkedList<>();
        // store row, col, distance
        q.add(new int[]{0,0,1});
        visited[0][0] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if(r == n-1 && c == m-1){
                ans = Math.min(ans,d);
            }
            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && grid[nr][nc] == 0) {
                    //if (nr == n-1 && nc == m-1) return d + 1;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args){
        int[][] matrix = {{0,0,1},{0,1,0},{0,1,0},{0,1,0}};
        System.out.println(shortestPathBinaryMatrix(matrix));
    }
}
