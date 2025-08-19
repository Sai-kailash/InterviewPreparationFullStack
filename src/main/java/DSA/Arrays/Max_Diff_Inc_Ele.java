package DSA.Arrays;

import java.util.stream.IntStream;

public class Max_Diff_Inc_Ele {

    public int maximumDifference(int[] nums) {

        int max_diff = -1;
        int diff;

        for(int i=0;i<nums.length+1;i++){

            diff = 0;
            for(int j=i+1;j<nums.length;j++){

                if(nums[j] > nums[i]){

                    diff = nums[j] - nums[i];

                    if(diff > max_diff)
                        max_diff = diff;
                }

            }
        }

        return max_diff;

    }

    public static void main(String[] args){
        Max_Diff_Inc_Ele mdc = new Max_Diff_Inc_Ele();
        System.out.println(mdc.maximumDifference(IntStream.of(87,68,91,86,58,63,43,98,6,40).toArray()));
    }
}
