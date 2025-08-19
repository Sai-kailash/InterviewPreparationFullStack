package DSA.Dynamic_Programming;

import java.util.stream.IntStream;

public class Dynamic_Robbery {

        public int rob(int[] nums) {

            int[] result = new int[nums.length];

            int max = 0;

            for(int i=0;i<nums.length;i++){

                if(i<=1) {
                    max = nums[i];
                    result[i] = max;
                    continue;
                }

                else
                    max = 0;

                for(int j=i-2;j>=0;j--){

                        if(result[j] + nums[i] > max)
                            max = result[j] + nums[i];
                }

                result[i] = max;
            }

            for(Integer val: result)
            {
                if(val > max)
                    max = val;
            }


            return max;
    }

    public static void main(String[] args){
            Dynamic_Robbery db = new Dynamic_Robbery();
            System.out.println(db.rob(IntStream.of(1,2,3,1).toArray()));
    }
}
