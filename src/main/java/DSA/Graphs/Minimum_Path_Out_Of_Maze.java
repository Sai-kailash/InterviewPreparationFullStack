package DSA.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Path_Out_Of_Maze {

    int min_path = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        List<List<Integer>> poss = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];

        int row = entrance[0];
        int col = entrance[1];

        isWallPresent(maze, row-1, col, poss);
        isWallPresent(maze, row+1, col, poss);
        isWallPresent(maze, row, col-1, poss);
        isWallPresent(maze, row, col+1, poss);

        visited[entrance[0]][entrance[1]] = true;

        for(int i=0;i<poss.size();i++){
            getMinimumPath(maze, poss.get(i).get(0), poss.get(i).get(1), visited, 0, entrance);
        }

        if(min_path == Integer.MAX_VALUE){
            return -1;
        } else{
            return min_path;
        }

    }

    private void getMinimumPath(char[][] maze, int row, int col, boolean[][] visited, int path, int[] entrance){

        try {
            if (visited[row][col]) {
                return;
            }
        } catch (Exception e) {
        }

        try{
            if(maze[row][col] == '.'){
                visited[row][col] = true;
                getMinimumPath(maze, row, col+1, visited, path + 1, entrance);
                getMinimumPath(maze, row, col-1, visited,path + 1, entrance);
                getMinimumPath(maze, row+1, col, visited,path + 1, entrance);
                getMinimumPath(maze, row-1, col, visited,path + 1, entrance);
            } else {
                return;
            }
        } catch(Exception e){
            if(row == entrance[0] && (col+1) == entrance[1]){
                return;
            }
            if(row == entrance[0] && (col-1) == entrance[1]){
                return;
            }
            if((row + 1) == entrance[0] && (col == entrance[1])){
                return;
            }
            if((row - 1) == entrance[0] && (col == entrance[1])){
                return;
            }

            if(min_path > path)
                min_path = path;
        }

    }

    private void isWallPresent(char[][] maze, int row, int col, List<List<Integer>> poss){

        try{
            if(maze[row][col] == '.'){
                poss.add(Arrays.asList(row, col));
            }
        } catch(Exception e){
            return;
        }

    }

    public static void main(String[] args){
        char[][] maze = {{'.','+'}};
        //char[][] maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        //char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        Minimum_Path_Out_Of_Maze m = new Minimum_Path_Out_Of_Maze();
        int[] entrance = {0,0};
        System.out.println(m.nearestExit(maze, entrance));
    }
}
