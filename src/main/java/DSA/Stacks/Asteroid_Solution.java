package DSA.Stacks;

import java.util.Stack;
import java.util.stream.IntStream;

public class Asteroid_Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        stack.push(asteroids[0]);

        for(int i=1;i<n;i++){

            if(asteroids[i]<0){

                if(stack.isEmpty()){
                    stack.push(asteroids[i]);
                    continue;
                }

                int temp = stack.size();
                int j=temp-1;
                Boolean is_push_reqd = false;
                while(!stack.isEmpty())
                {

                    if(stack.get(j) + asteroids[i] == 0){
                        is_push_reqd = false;
                        stack.pop();
                        break;
                    }

                    else if(stack.get(j) < 0){
                        is_push_reqd = true;
                        break;
                    }

                    if(stack.get(j) + asteroids[i] < 0){
                        is_push_reqd = true;
                        stack.pop();

                    }

                    else if(stack.get(j) + asteroids[i] > 0){
                        is_push_reqd = false;
                        break;
                    }

                    j--;
                }

                if(is_push_reqd)
                    stack.push(asteroids[i]);
            }

            else
            {
                stack.push(asteroids[i]);
            }
        }

        int[] result = new int[stack.size()];
        int f = 0;
        for(Integer val: stack){
            result[f] = val;
            f++;
        }

        return result;
    }

    public static void main(String[] args){
        Asteroid_Solution as = new Asteroid_Solution();
        int[] asteroids = IntStream.of(1,-1,-2,-2).toArray();
        int[] result = as.asteroidCollision(asteroids);

        for(int j=0;j<result.length;j++)
            System.out.println(result[j]);

    }
}
