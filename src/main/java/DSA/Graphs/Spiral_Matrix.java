package DSA.Graphs;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        List<Integer> result = new ArrayList<>();

        int count = 0;
        int[][] dirs = new int[][]{{0, 1},{1, 0},{0, -1},{-1, 0}};
        int row = 0;
        int col = 0;
        int start_index = 0;

        while(count < m*n){
            if(row >=0 && row < m && col >=0 && col < n){
                if(!visited[row][col]){
                    result.add(matrix[row][col]);
                    visited[row][col] = true;
                    count++;
                }
                else{
                    row -= dirs[start_index][0];
                    col -= dirs[start_index][1];

                    start_index = (start_index + 1)%4;
                }
            }
            else{
                row -= dirs[start_index][0];
                col -= dirs[start_index][1];

                start_index = (start_index + 1)%4;
            }

            row += dirs[start_index][0];
            col += dirs[start_index][1];
        }

        return result;

    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Spiral_Matrix s= new Spiral_Matrix();
        s.spiralOrder(matrix);
    }
}
