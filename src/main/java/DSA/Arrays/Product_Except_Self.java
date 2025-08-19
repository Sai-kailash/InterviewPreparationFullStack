package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Product_Except_Self {
        public int[] productExceptSelf(int[] nums) {

            int[] result = new int[nums.length];

            List<Integer> zeros = new ArrayList<>();

            int prod = 1;
            for(int j=0;j<nums.length;j++) {
                if (nums[j] != 0)
                    prod = nums[j] * prod;
                else
                    zeros.add(j);
            }

            int[] zeroes = zeros.stream().mapToInt(Integer::intValue).toArray();

            for(int i=0;i<nums.length;i++){

                if(nums[i] == 0){
                    if(zeroes.length > 1){
                        result[i] = 0;
                    }

                    else
                        result[i] = prod;
                }

                else if(nums[i]!=0){

                    if(zeroes.length >= 1){
                        result[i] = 0;
                    }

                    else
                        result[i] = prod/nums[i];
                }



            }

            return result;
        }

        public static void main(String[] args){

            Product_Except_Self pf = new Product_Except_Self();
            int[] result = pf.productExceptSelf(IntStream.of(-1,1,0,-3,3).toArray());

            for(Integer val: result)
                 System.out.println(val);
        }
}
