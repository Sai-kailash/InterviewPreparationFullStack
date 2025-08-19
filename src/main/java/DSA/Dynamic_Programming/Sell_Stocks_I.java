package DSA.Dynamic_Programming;

import java.util.stream.IntStream;

public class Sell_Stocks_I {
    public int maxProfit(int[] prices) {

        int[] dp = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }
            dp[i] = (prices[i] - min >= 0) ? Math.max(dp[i-1], prices[i] - min):dp[i-1];
        }

        return dp[prices.length - 1];
    }

    public int rob(int[] nums) {

        if(nums.length == 2){ return Math.max(nums[0], nums[1]);}

        int[][] dp = new int[nums.length][2];
        int i=0;

        for(i=0;i<nums.length-1;i++){
            if(i==0){
                dp[i][0] = nums[i];
                dp[i][1] = 1;
            }
            else if(i==1){
                dp[i][0] = Math.max(dp[0][0], nums[i]);
                if(dp[i][0] == nums[i]){
                    dp[i][1] = 0;
                } else {
                    dp[i][1] = dp[0][1];
                }
            }

            else{
                dp[i][0] = Math.max(dp[i-2][0] + nums[i], dp[i-1][0]);

                if(dp[i][0] == (dp[i-2][0] + nums[i])){
                    dp[i][1] = dp[i-2][1];
                }
                else if(dp[i][0] == dp[i-1][0]){
                    dp[i][1] = dp[i-1][1];
                }

            }
        }

        if(nums.length == 1){ return nums[0]; }

        if(nums.length == 3){ return Math.max(dp[1][0], nums[2]); }

        if(dp[i-1][1] == 1 && dp[i-2][1] == 1){
            dp[i][0] = dp[i-1][0];
        }

        else if(dp[i-1][1] == 0 && dp[i-2][1] == 0){
            dp[i][0] = dp[i-2][0] + nums[i];
        }

        else if(dp[i-1][1] == 1 && dp[i-2][1] == 0){
            dp[i][0] = Math.max(dp[i-2][0] + nums[i], dp[i-1][0]);
        }

        else if(dp[i-1][1] == 0 && dp[i-2][1] == 1){
            dp[i][0] = Math.max(dp[i-1][0] + nums[0], dp[i-2][0]);
        }

        return dp[nums.length-1][0];

    }

    public static void main(String[] args){
        int[] prices = IntStream.of(7,1,5,3,6,4).toArray();
        Sell_Stocks_I s = new Sell_Stocks_I();
        //s.maxProfit(prices);
        System.out.println(s.rob(IntStream.of(1,1,3,6,7,10,7,1,8,5,9,1,4,4,3).toArray()));
    }
}
