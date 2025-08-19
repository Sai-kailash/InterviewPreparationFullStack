package DSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Partition_Array {
    public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        int min = nums[0];
        res.add(nums[0]);

        for(int i=1;i<nums.length;i++){

            if((nums[i] - min) <= k){
                res.add(nums[i]);
            }

            else{
                result.add(res);
                res = new ArrayList<>();
                res.add(nums[i]);
                min = nums[i];
            }

        }

        result.add(res);
        return result.size();

    }

    public static void main(String[] args){
        Partition_Array pa = new Partition_Array();
        pa.partitionArray(IntStream.of(3,6,1,2,5).toArray(), 2);
    }
}
