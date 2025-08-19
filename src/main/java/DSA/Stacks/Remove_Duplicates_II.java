package DSA.Stacks;

import java.util.Stack;

public class Remove_Duplicates_II {

    public String removeDuplicates(String s, int k) {

        String result = "";
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<s.length()){

            char ch = s.charAt(i);

            if(!stack.isEmpty()){
                if(stack.peek() == ch){
                    if(i<s.length()-1 && s.charAt(i+1) == ch){
                        stack.push(ch);
                        i++;
                        continue;
                    }
                    int count = 1;
                    int j=stack.size()-1;
                    while(j>=0 && stack.get(j) == ch){
                        count++;
                        j--;
                    }

                    if(count >= k){
                        int loop = 1;
                        while(loop<(count - count%k)){
                            stack.pop();
                            loop++;
                        }
                    } else {
                        stack.push(ch);
                    }
                } else {
                    stack.push(ch);
                }
            }
            else{
                stack.push(ch);
            }
            i++;
        }

        for(Character c: stack){
            result+=c;
        }

        return result;
    }

    public static void main(String[] args){
        Remove_Duplicates_II r = new Remove_Duplicates_II();
        System.out.println(r.removeDuplicates("deeedbbcccbdaa", 3));
    }
}
