package DSA.Arrays;

public class SecondHighest {

    public int getSecondHighest(int[] nums){
        int n = nums.length;

        int f = Math.max(nums[0], nums[1]);
        int s = Math.min(nums[0], nums[1]);

        for(int i=2;i<n;i++){
            if(nums[i] > f){
                s = f;
                f = nums[i];
            }

            else if(nums[i] > s){
                s = nums[i];
            }
        }

        return s;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};

        SecondHighest sh = new SecondHighest();

        System.out.println(sh.getSecondHighest(nums));
    }
}
