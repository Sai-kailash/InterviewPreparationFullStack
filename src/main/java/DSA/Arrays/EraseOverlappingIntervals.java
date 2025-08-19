package DSA.Arrays;

import java.util.Arrays;

public class EraseOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(b[1], a[1]));
        int count = 0;
        int min = min = intervals[0][1];

        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0] < min)
                count++;

            else if(intervals[i][0] >= min){
                min = intervals[i][1];
            }
        }

        return count;

    }

    public static void main(String[] args){

        EraseOverlappingIntervals ei = new EraseOverlappingIntervals();
        int[][] intervals = {};
        System.out.println(ei.eraseOverlapIntervals(intervals));

    }
}
