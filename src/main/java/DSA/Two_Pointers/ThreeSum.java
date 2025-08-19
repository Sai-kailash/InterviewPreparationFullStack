package DSA.Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<=nums.length-3;i++){

            if(i>0){
                if(nums[i] == nums[i-1])
                    continue;
            }

            int first = i++;
            int last = nums.length-1;

            while(first<last){

                if(nums[first] + nums[last] + nums[i] == 0){
                    result.add(Arrays.asList(nums[first], nums[last], nums[i]));

                }

                else if((nums[first] + nums[last]) < 0)
                    first++;

                else
                    last--;

            }
        }

        return result;

    }

    public static void main(String[] args){
        ThreeSum ts = new ThreeSum();
        ts.threeSum(IntStream.of(-1,0,1,2,-1,4).toArray());
    }
}
