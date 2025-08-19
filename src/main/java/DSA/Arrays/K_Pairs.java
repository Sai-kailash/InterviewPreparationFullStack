package DSA.Arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class K_Pairs {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        int count = 0;

        for(int i=0;i<nums.length-1;i++){

            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int ele = k + nums[i];
            int left = i+1;
            int right = nums.length - 1;

            int mid = left + (right -left)/2;
            int found = 0;
            while(left <= right){

                mid = left + (right -left)/2;

                if(nums[mid] < ele){
                    left = mid+1;
                }

                else if(nums[mid] > ele){
                    right = mid-1;
                }

                else if(nums[mid] == ele){
                    found = 1;
                    count++;
                    break;
                }

            }
        }

        return count;

    }

    public static void main(String[] args){

        K_Pairs p = new K_Pairs();
        System.out.println(p.findPairs(IntStream.of(3,1,4,1,5).toArray(), 2));
    }
}
