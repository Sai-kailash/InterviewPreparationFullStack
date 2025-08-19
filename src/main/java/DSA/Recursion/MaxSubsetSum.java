package DSA.Recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MaxSubsetSum {

    Map<Integer, Integer> map = new HashMap<>();
    int max_sum;
    public int countMaxOrSubsets(int[] nums) {

        for(int i=0;i<nums.length;i++) {
            getMaxSubsets(nums, i, 0);
        }
        return map.get(max_sum);

    }

    private void getMaxSubsets(int[] nums, int start, int prev_sum){

        prev_sum = prev_sum | nums[start];
        if(map.containsKey(prev_sum)){
            map.put(prev_sum, map.get(prev_sum) + 1);
        }
        else{
            map.put(prev_sum, 1);
        }

        if(max_sum < prev_sum){
            max_sum = prev_sum;
        }

        for(int i=start+1;i<nums.length;i++){
            getMaxSubsets(nums, i, prev_sum);
        }
    }

    public static void main(String[] args){
        int[] nums = IntStream.of(2,2,2).toArray();
        MaxSubsetSum s = new MaxSubsetSum();
        System.out.println(s.countMaxOrSubsets(nums));
    }
}
