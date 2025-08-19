package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiscountTags {

    public static long maxEvenSum(List<Integer> tags) {
        long totalSum = 0;
        int minOdd = Integer.MAX_VALUE; // To store the smallest positive odd number
        int maxNegativeOdd = Integer.MIN_VALUE; // To store the largest (closest to zero) negative odd number
        boolean hasOdd = false;

        for (int tag : tags) {
            totalSum += tag;
            if (tag % 2 != 0) { // If the number is odd
                hasOdd = true;
                if (tag > 0) {
                    minOdd = Math.min(minOdd, tag);
                } else { // tag is negative odd
                    maxNegativeOdd = Math.max(maxNegativeOdd, tag);
                }
            }
        }

        if (totalSum % 2 == 0) {
            return totalSum; // If the total sum is already even, it's the maximum possible
        } else {
            // Total sum is odd. We need to remove an odd number to make it even.
            // To maximize the sum, we should remove the smallest absolute value odd number.
            // This means either the smallest positive odd number or the largest negative odd number.

            long maxPossibleEvenSum = Long.MIN_VALUE; // Initialize with a very small value

            // Case 1: Try to remove a positive odd number
            if (minOdd != Integer.MAX_VALUE) {
                maxPossibleEvenSum = Math.max(maxPossibleEvenSum, totalSum - minOdd);
            }

            // Case 2: Try to remove a negative odd number
            // (Only applicable if there are negative odd numbers and no positive odd numbers were good enough,
            // or if removing a negative odd leads to a better result, which it might not if we are seeking
            // to remove the *smallest absolute value*.)
            if (maxNegativeOdd != Integer.MIN_VALUE) {
                maxPossibleEvenSum = Math.max(maxPossibleEvenSum, totalSum - maxNegativeOdd);
            }

            // Important consideration: What if we can't make an even sum?
            // The problem statement says "There is at least one tag with an even value."
            // This implies we can always form an even sum (e.g., by just picking that even value).
            // However, the question is about the *maximum* possible even sum.

            // Re-evaluating the logic for an odd total sum:
            // If totalSum is odd, we need to remove an odd number.
            // To maximize the remaining sum, we should remove the odd number with the smallest absolute value.
            // This could be:
            // 1. The smallest positive odd number.
            // 2. The largest negative odd number (closest to zero).

            if (!hasOdd) {
                // This case shouldn't happen based on "totalSum % 2 != 0"
                // if all numbers were even, totalSum would be even.
                // If there are no odd numbers and totalSum is odd, it's a logical contradiction.
                // So, if totalSum is odd, there MUST be at least one odd number.
                return 0; // If somehow no odd numbers could be found (e.g., empty list or only even numbers but totalSum somehow odd - invalid scenario)
            }

            int smallestAbsoluteOdd = Integer.MAX_VALUE; // Smallest absolute value of an odd number
            for (int tag : tags) {
                if (tag % 2 != 0) {
                    if (Math.abs(tag) < Math.abs(smallestAbsoluteOdd)) {
                        smallestAbsoluteOdd = tag;
                    }
                }
            }
            return totalSum - smallestAbsoluteOdd;
        }
    }

    public static void main(String[] args) {
        // Test cases from the image example:
        List<Integer> tags1 = new ArrayList<>();
        tags1.add(2);
        tags1.add(3);
        tags1.add(6);
        tags1.add(-5);
        tags1.add(10);
        tags1.add(1);
        tags1.add(1);
        System.out.println("Tags: [2, 3, 6, -5, 10, 1, 1]");
        System.out.println("Max Even Sum: " + maxEvenSum(tags1)); // Expected: 18 (2+3-6+8+10+1 = 18, which is even)

        // Custom test cases:
//        List<Integer> tags2 = new ArrayList<>();
//        tags2.add(1);
//        tags2.add(2);
//        tags2.add(3);
//        System.out.println("\nTags: [1, 2, 3]");
//        System.out.println("Max Even Sum: " + maxEvenSum(tags2)); // Total sum = 6 (even). Expected: 6
//
//        List<Integer> tags3 = new ArrayList<>();
//        tags3.add(1);
//        tags3.add(2);
//        tags3.add(5);
//        System.out.println("\nTags: [1, 2, 5]");
//        System.out.println("Max Even Sum: " + maxEvenSum(tags3)); // Total sum = 8 (even). Expected: 8
//
//        List<Integer> tags4 = new ArrayList<>();
//        tags4.add(1);
//        tags4.add(3);
//        tags4.add(5);
//        System.out.println("\nTags: [1, 3, 5]");
//        System.out.println("Max Even Sum: " + maxEvenSum(tags4)); // Total sum = 9 (odd). Remove 1 -> 8. Expected: 8
//
//        List<Integer> tags5 = new ArrayList<>();
//        tags5.add(-1);
//        tags5.add(-3);
//        tags5.add(-5);
//        System.out.println("\nTags: [-1, -3, -5]");
//        System.out.println("Max Even Sum: " + maxEvenSum(tags5)); // Total sum = -9 (odd). Remove -1 -> -8. Expected: -8
//
//        List<Integer> tags6 = new ArrayList<>();
//        tags6.add(10);
//        tags6.add(20);
//        tags6.add(30);
//        System.out.println("\nTags: [10, 20, 30]");
//        System.out.println("Max Even Sum: " + maxEvenSum(tags6)); // Total sum = 60 (even). Expected: 60
//
//        List<Integer> tags7 = new ArrayList<>();
//        tags7.add(-1);
//        tags7.add(2);
//        tags7.add(3);
//        System.out.println("\nTags: [-1, 2, 3]");
//        System.out.println("Max Even Sum: " + maxEvenSum(tags7)); // Total sum = 4 (even). Expected: 4
//
//        List<Integer> tags8 = new ArrayList<>();
//        tags8.add(-2);
//        tags8.add(-3);
//        tags8.add(-5);
//        System.out.println("\nTags: [-2, -3, -5]");
//        System.out.println("Max Even Sum: " + maxEvenSum(tags8)); // Total sum = -10 (even). Expected: -10
    }
}