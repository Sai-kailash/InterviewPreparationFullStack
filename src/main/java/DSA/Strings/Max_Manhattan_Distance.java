package DSA.Strings;

import java.util.HashMap;
import java.util.Map;

public class Max_Manhattan_Distance {
    public int maxDistance(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        int count_n = map.getOrDefault('N', 0);
        int count_s = map.getOrDefault('S', 0);

        int count_w = map.getOrDefault('W', 0);
        int count_e = map.getOrDefault('E', 0);

        char c1;
        char c2;

        if(count_n > count_s)
            c1 = 'N';
        else
            c1 = 'S';

        if(count_e > count_w)
            c2 = 'E';
        else
            c2 = 'W';

        int x=0;
        int y=0;
        int d=0;
        int max_d=0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == c1){
                if(k>0){
                    if(ch == 'N')
                        y-=1;
                    else
                        y+=1;

                    k--;
                }
                else{
                    if(ch == 'N')
                        y+=1;
                    else
                        y-=1;
                }
            }

            else if(ch == c2){
                if(k>0){
                    if(ch == 'E')
                        x-=1;
                    else
                        x+=1;

                    k--;
                }
                else {

                    if(ch == 'E')
                        x+=1;
                    else
                        x-=1;
                }
            }

            else{

                if(ch == 'N')
                    y+=1;
                else if(ch == 'S')
                    y-=1;
                else if(ch == 'E')
                    x+=1;
                else
                    x-=1;
            }

            d = Math.abs(x) + Math.abs(y);

            if(d > max_d)
                max_d = d;
        }

        return max_d;

    }

    public static void main(String[] args){
        Max_Manhattan_Distance mh = new Max_Manhattan_Distance();
        System.out.println(mh.maxDistance("NWSE", 1));
    }
}
