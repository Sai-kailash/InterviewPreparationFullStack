package DSA.Arrays;

import java.util.stream.IntStream;

public class Peak_Binary_Search {

    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while(left<right){

            int mid = left + (right - left)/2;

            if(nums[mid]<nums[mid+1])
                left = mid+1;
            else
                right = mid;
        }

        return right;
    }

    public static void main(String[] args){
        Peak_Binary_Search ps = new Peak_Binary_Search();
        System.out.println(ps.findPeakElement(IntStream.of(1,2,1,3,5,6,4).toArray()));
    }
}
