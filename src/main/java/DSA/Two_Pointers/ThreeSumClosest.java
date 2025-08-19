package DSA.Two_Pointers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int diff = Integer.MAX_VALUE;
        int target_sum = 0;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int sum = nums[i];
            int left = i+1;
            int right = nums.length -1;
            int req_sum = target - sum;
            while(left < right){

                if(Math.abs(nums[right] + nums[left] + sum - target) < diff){
                    target_sum = sum + nums[right] + nums[left];
                    diff = nums[right] + nums[left] + sum - target;
                }

                if(nums[left] + nums[right] < req_sum){
                    left++;
                }
                else if(nums[left] + nums[right] > req_sum){
                    right--;
                }
                else{
                    return target;
                }


            }
        }

        return target_sum;

    }

    public static void main(String[] args){
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.threeSumClosest(IntStream.of(10,20,30,40,50,60,70,80,90).toArray(), 1));
    }
}
