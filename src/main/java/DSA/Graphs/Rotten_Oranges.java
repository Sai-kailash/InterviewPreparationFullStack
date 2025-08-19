package DSA.Graphs;

import java.util.*;

public class Rotten_Oranges {

//    public int orangesRotting(int[][] grid) {
//
//        int m = grid.length;
//        int n = grid[0].length;
//        int count_f = 0;
//        int count_r = 0;
//        List<List<Integer>> list = new ArrayList<>();
//
//        for(int i=0;i<m;i++){
//
//            for(int j=0;j<n;j++){
//                if(grid[i][j] == 2){
//                    count_r++;
//                    list.add(Arrays.asList(i,j));
//                }
//                else if(grid[i][j] == 1){
//                    count_f++;
//                }
//            }
//        }
//
//        if(count_r == 0){
//            if(count_f > 0){
//                return -1;
//            }
//            else if(count_f == 0){
//                return 0;
//            }
//        }
//
//        if(count_f == 0){
//            return 0;
//        }
//
//        List<List<Integer>> new_list;
//        int minute = 0;
//        int initial_count_f = count_f;
//        int initial_count_r = count_r;
//        while(!list.isEmpty()){
//
//            new_list = new ArrayList<>();
//
//            for(int i=0;i<list.size();i++){
//                int row = list.get(i).get(0);
//                int col = list.get(i).get(1);
//
//                addRottenOrange(grid, row-1, col, new_list);
//                addRottenOrange(grid, row+1, col, new_list);
//                addRottenOrange(grid, row, col-1, new_list);
//                addRottenOrange(grid, row, col+1, new_list);
//
//            }
//
//            int prev_count_f = count_f;
//            minute++;
//            list.clear();
//            for(int i=0;i<new_list.size();i++) {
//                if (grid[new_list.get(i).get(0)][new_list.get(i).get(1)] == 1) {
//                    grid[new_list.get(i).get(0)][new_list.get(i).get(1)] = 2;
//                    count_f--;
//                    count_r++;
//                    list.add(Arrays.asList(new_list.get(i).get(0), new_list.get(i).get(1)));
//                }
//            }
//        }
//
//        if(count_r == initial_count_r + initial_count_f){
//            return minute-1;
//        } else {
//            return -1;
//        }
//    }
//
//    private void addRottenOrange(int[][] grid, int row, int col, List<List<Integer>> new_list){
//
//        try{
//            if(grid[row][col] == 1){
//                new_list.add(Arrays.asList(row, col));
//            }
//        } catch(Exception e){
//             return;
//        }
//
//    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int minute = 0;
        int count_f = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                } else if(grid[i][j] == 1){
                    count_f++;
                }
            }
        }

        if(count_f == 0){ return 0;}
        if(q.isEmpty()) {return -1;}

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        while(!q.isEmpty()){

            List<List<Integer>> new_list = new ArrayList<>();
            while(!q.isEmpty()){

                int[] orange = q.poll();
                int row = orange[0];
                int col = orange[1];

                addRottenOranges(row, col, new_list, dirs, m, n, grid);
            }
            if(!new_list.isEmpty())
                minute++;

            for(int j=0;j<new_list.size();j++){

                if(grid[new_list.get(j).get(0)][new_list.get(j).get(1)] == 1){

                    grid[new_list.get(j).get(0)][new_list.get(j).get(1)] = 2;
                    q.offer(new int[]{new_list.get(j).get(0), new_list.get(j).get(1)});
                    count_f--;

                }
            }

        }

        if(count_f == 0){
            return minute;
        } else{
            return -1;
        }
    }

    private void addRottenOranges(int row, int col, List<List<Integer>> new_list, int[][] dirs, int m, int n, int[][] grid){
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if((nr>=0 && nr<m) && (nc>=0 && nc<n) && (grid[nr][nc] == 1)){
                new_list.add(Arrays.asList(nr, nc));
            }
        }
    }

    public static void main(String[] args){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        Rotten_Oranges ro = new Rotten_Oranges();
        System.out.println(ro.orangesRotting(grid));
    }

}
