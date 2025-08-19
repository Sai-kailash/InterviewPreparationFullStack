package DSA.Companies.GoldManSachs;

import java.util.*;

public class MaxSubarrayLength {
    public static int maxSubarrayLen(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int left = 0;
        int windowSum = 0;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            windowSum += arr[right];

            // Maintain increasing deque for min
            while (!minDeque.isEmpty() && arr[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offerLast(arr[right]);

            // Maintain decreasing deque for max
            while (!maxDeque.isEmpty() && arr[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(arr[right]);

            // Shrink window while condition fails
            while (left <= right && windowSum <= maxDeque.peekFirst() - minDeque.peekFirst()) {
                windowSum -= arr[left];
                if (arr[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                if (arr[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                left++;
            }

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 4};
        System.out.println(maxSubarrayLen(arr)); // Output: 2
    }
}
