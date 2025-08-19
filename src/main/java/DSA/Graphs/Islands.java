package DSA.Graphs;

public class Islands {

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int islands = 0;

        boolean[][] visited = new boolean[m][n];

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    formAnIsland(grid, i, j, m, n, visited, dirs);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void formAnIsland(char[][] grid, int row, int col, int m, int n, boolean[][] visited, int[][] dirs){

        visited[row][col] = true;

        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >=0 && nr <m && nc >=0 && nc < n && !visited[nr][nc] && grid[nr][nc] == '1'){
                formAnIsland(grid, nr, nc, m, n, visited, dirs);
            }
        }
    }

    public static void main(String[] args){
        char[][] grid = new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Islands i = new Islands();
        System.out.println(i.numIslands(grid));
    }
}
