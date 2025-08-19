package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class XOR_Subsets {
    public int subsetXORSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        int sum = 0;

        //System.out.println(result.size());

        for(int i=0;i<result.size();i++){

            int sum1 = 0;

            for(int j=0;j<result.get(i).size();j++) {

                sum1 = sum1 ^ result.get(i).get(j);
            }
            //System.out.println(sum1);
            sum = sum + sum1;
        }

        return sum;

    }

    public void backtrack(int pos, int[] nums, List<Integer> temp, List<List<Integer>> result){

        result.add(new ArrayList<>(temp));

        for(int i=pos;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(i+1, nums, temp, result);
            temp.removeLast();
        }

    }

    public static void main(String[] args){

        XOR_Subsets sb = new XOR_Subsets();
        System.out.println(sb.subsetXORSum(IntStream.of(1,3).toArray()));
    }
}
