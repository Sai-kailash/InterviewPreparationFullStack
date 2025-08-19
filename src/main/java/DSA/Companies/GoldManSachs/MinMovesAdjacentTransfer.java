package DSA.Companies.GoldManSachs;

/**
 * Returns the minimum number of operations needed to make every element equal
 * when one operation means taking 1 from arr[i] and giving it to arr[i-1] or arr[i+1].
 * If it’s impossible (sum not divisible by n) the method returns -1.
 */
public class MinMovesAdjacentTransfer {

    public static int minMoves(int[] arr) {
        int n = arr.length;
        long total = 0;
        for (int x : arr) total += x;

        // Feasibility check
        if (total % n != 0) return -1;
        long target = total / n;

        long imbalance = 0;     // running extra / deficit
        int maxOps     = 0;     // answer

        for (int val : arr) {
            imbalance += val - target;         // net surplus that must move right
            maxOps = Math.max(maxOps, (int)Math.abs(imbalance));
            // max(|imbalance|) is the tight lower-bound on moves
        }
        return maxOps;
    }

    // --- quick demo ---
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 0, 5}));      // 3
        System.out.println(minMoves(new int[]{2, 2, 2}));      // 0
        System.out.println(minMoves(new int[]{4, 0, 0, 4}));   // 4
        System.out.println(minMoves(new int[]{3, 1, 2}));      // -1 (sum not divisible by n)
    }
}
