package DSA.Arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Spells_Potions_Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {

            if (i > 0) {
                if (spells[i] == spells[i - 1]) {
                    result[i] = result[i - 1];
                    continue;
                }
            }

            int spell = spells[i];
            int left = 0;
            int right = potions.length - 1;

            int mid = left + (right - left) / 2;
            int nearest = potions.length;

            int pointer = 0;

            while (left <= right) {

                mid = left + (right - left) / 2;

                long mult = (long) spell * potions[mid];

                if (mult < success) {
                    left = mid + 1;

                } else if (mult > success) {

                    if (nearest > mid)
                        nearest = mid;

                    right = mid - 1;
                } else {

                    pointer = 1;
                    break;
                }

            }

            if ((left > right) && (nearest == potions.length) && (pointer == 0))
                result[i] = 0;

            else if (pointer == 1) {

                while (mid >= 0) {

                    long mult = (long) spell * potions[mid];

                    if (mult == success)
                        mid--;
                    else
                        break;
                }

                if (mid == -1)
                    result[i] = potions.length;
                else
                    result[i] = potions.length - mid - 1;
            } else {

                while (nearest >= 0) {

                    long mult = (long) spell * potions[nearest];


                    if (mult > success)
                        nearest--;
                    else
                        break;
                }

                if (nearest == -1)
                    result[i] = potions.length;

                else
                    result[i] = potions.length - nearest - 1;
            }

        }

        return result;

    }

public static void main(String[] args){

    Spells_Potions_Solution sp = new Spells_Potions_Solution();

            int[] result = sp.successfulPairs(IntStream.of(40,11,24,28,40,22,26,38,28,10,31,16,10,37,13,21,9,22,21,18,34,2,40,40,6,16,9,14,14,15,37,15,32,4,27,20,24,12,26,39,32,39,20,19,22,33,2,22,9,18,12,5).toArray(), IntStream.of(31,40,29,19,27,16,25,8,33,25,36,21,7,27,40,24,18,26,32,25,22,21,38,22,37,34,15,36,21,22,37,14,31,20,36,27,28,32,21,26,33,37,27,39,19,36,20,23,25,39,40).toArray(), 600);

            for(int i=0;i<result.length;i++){
                System.out.println(result[i]);
            }
        }
}
