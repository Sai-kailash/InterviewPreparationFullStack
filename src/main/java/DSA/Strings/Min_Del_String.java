package DSA.Strings;

import java.util.HashMap;
import java.util.Map;

public class Min_Del_String {
    public int minimumDeletions(String word, int k) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int count = 0;

        for(int i=0;i<word.length()-1;i++){

            char ch1 = word.charAt(i);

            for(int j=i+1;j<word.length();j++){

                char ch2 = word.charAt(j);
                int mod = Math.abs(map.get(ch1) - map.get(ch2));

                if(mod > k){
                    count++;
                    map.put(ch1, map.get(ch1) - 1);
                    break;
                }
            }
        }

        return count;

    }

    public static void main(String[] args){
        Min_Del_String min = new Min_Del_String();
        System.out.println(min.minimumDeletions("aabcaba", 0));
    }
}
