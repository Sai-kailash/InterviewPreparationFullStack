package DSA.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited = new boolean[m][n];
                visited[i][j] = true;
                boolean b1 = isPacific(heights, m, n, i, j, dirs, visited);
                visited = new boolean[m][n];
                visited[i][j] = true;
                boolean b2 = isAtlantic(heights, m, n, i, j,  dirs, visited);

                if(b1 && b2){
                    result.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }

        return result;
    }

    private boolean isPacific(int[][] heights, int m, int n, int row, int col, int[][] dirs, boolean[][] visited){
        if(row == 0 || col == 0){
            return true;
        }

        boolean pacific = false;

        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >= 0 && nc >= 0 && nr < m && nc < n
                    && !visited[nr][nc]
                    && heights[nr][nc] <= heights[row][col]) {

                visited[nr][nc] = true;
                if (isPacific(heights, m, n, nr, nc, dirs, visited)) {
                    pacific = true;
                    break;  // no need to explore further once true
                }
            }
        }

        return pacific;
    }

    private boolean isAtlantic(int[][] heights, int m, int n, int row, int col, int[][] dirs, boolean[][] visited){
        if(row == m-1 || col == n-1){
            return true;
        }

        boolean atlantic = false;

        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >= 0 && nc >= 0 && nr < m && nc < n
                    && !visited[nr][nc]
                    && heights[nr][nc] <= heights[row][col]) {

                visited[nr][nc] = true;
                if (isAtlantic(heights, m, n, nr, nc, dirs, visited)) {
                    atlantic = true;
                    break;
                }
            }
        }

        return atlantic;
    }

    public static void main(String[] args){
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        PacificAtlantic p = new PacificAtlantic();
        p.pacificAtlantic(heights);
    }
}
