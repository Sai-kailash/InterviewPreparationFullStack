package DSA;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Longest_Harmonic_Subsequence {

    public int findLHS(int[] nums) {

        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(nums[0]);
        int max_size = 0;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == pq.peek() || (pq.peek() + 1) == nums[i]){
                pq.offer(nums[i]);
            }
            else{
                int size = pq.size();

                if(size > max_size){
                    max_size = size;
                }
                while(!pq.isEmpty() && nums[i]-pq.peek() > 1){ pq.poll(); }
                pq.offer(nums[i]);
            }
        }

        if(pq.size() > max_size)
           return pq.size();

        return max_size;

    }

    public static void main(String[] args){
        Longest_Harmonic_Subsequence l = new Longest_Harmonic_Subsequence();
        System.out.println(l.findLHS(IntStream.of(1,2,2,1).toArray()));
    }
}
