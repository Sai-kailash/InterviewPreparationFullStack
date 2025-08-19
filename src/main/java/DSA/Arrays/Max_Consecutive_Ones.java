package DSA.Arrays;

import java.util.stream.IntStream;

public class Max_Consecutive_Ones {

    public int longestOnes(int[] nums, int k) {

        int max_count = 0;

        for(int i=0;i<nums.length;i++){

            int k_dash = k;
            int count = 0;

            for(int j=i;j<nums.length;j++){

                if(nums[j] == 1){
                    count++;
                }

                else if((nums[j] == 0) && (k_dash !=0)){
                    k_dash--;
                    count++;
                }

                else if((nums[j] == 0) && (k_dash ==0)){
                    break;
                }

            }

            if(max_count < count)
                max_count = count;
        }

        return max_count;

    }

    public static void main(String[] args){

        Max_Consecutive_Ones mco = new Max_Consecutive_Ones();
        System.out.println(mco.longestOnes(IntStream.of(0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1).toArray(), 3));
    }
}
