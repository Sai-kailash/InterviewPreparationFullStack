package DSA.Dynamic_Programming;

public class Max_Path_Gold {

    int max_path = 0;
    public int getMaximumGold(int[][] grid) {

        int m=grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0){
                    getMaxPath(grid, i, j, m, n, grid[i][j], visited, dirs);
                    visited[i][j] = false;
                }
            }
        }

        return max_path;
    }

    private void getMaxPath(int[][] grid, int row, int col, int m, int n, int path, boolean[][] visited, int[][] dirs){
        visited[row][col] = true;
        if(path > max_path){
            max_path = path;
        }

        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && (grid[nr][nc] != 0)){
                getMaxPath(grid, nr, nc, m, n, path + grid[nr][nc], visited, dirs);
                visited[nr][nc] = false;
            }
        }
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        Max_Path_Gold m =new Max_Path_Gold();
        System.out.println(m.getMaximumGold(grid));
    }
}
