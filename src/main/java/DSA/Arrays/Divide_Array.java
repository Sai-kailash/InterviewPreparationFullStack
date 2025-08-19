package DSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Divide_Array {

        public int[][] divideArray(int[] nums, int k) {

            List<List<Integer>> result = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            int index=0;
            int result_count = 0;

            Arrays.sort(nums);

            for(int i=0;i<nums.length-2;i++){

                int comp = nums[i];

                if(nums[i] == 0)
                    continue;

                int j=i+1;
                res = new ArrayList<>();
                res.add(nums[i]);
                while((j<nums.length) && (res.size() < 3)){

                    if(((nums[j] - comp) <= k) && (nums[j] - res.get(0) <= k)){
                        res.add(nums[j]);
                        index = j;
                        comp = nums[j];
                        nums[j] = 0;
                    }
                    j++;
                }

                if(res.size() == 3){
                    result.add(res);
                }

                else if(res.size() == 2)
                    nums[index] = res.get(1);

            }

            if(result.size() == nums.length/3){
                int[][] set = new int[result.size()][3];
                for(int row=0;row<result.size();row++){

                    List<Integer> row_list = result.get(row);

                    for(int col=0;col<3;col++){

                        set[row][col] = row_list.get(col);

                    }
                }
                return set;
            }
            else
                return new int[0][0];

        }

        public static void main(String[] args){
            Divide_Array da = new Divide_Array();
            int[][] result = da.divideArray(IntStream.of(4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11).toArray(), 14);
        }
}
