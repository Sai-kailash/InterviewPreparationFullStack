package DSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(b[1], a[1]);
        });

        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(intervals[0][0], intervals[0][1]));

        for(int i=1;i<intervals.length;i++){
            int n = result.size();
            int result_0 = result.get(n-1).get(0);
            int result_1 = result.get(n-1).get(1);

            int first = intervals[i][0];
            int last = intervals[i][1];

            if(last >= result_1){

                if(first > result_1){
                    result.add(Arrays.asList(first, last));
                }

                else{
                    result.set(n-1, Arrays.asList(result_0, last));
                }

            }
        }

        int[][] res = new int[result.size()][2];
        int i=0;

        for(List<Integer> li: result){
            res[i][0] = li.get(0);
            res[i][1] = li.get(1);
            i++;
        }

        return res;

    }

    public static void main(String[] args){
        Merge_Intervals m = new Merge_Intervals();
        int[][] a = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res2 = m.merge(a);
    }
}
