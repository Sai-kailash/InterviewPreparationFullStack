package DSA.Stacks;

import java.util.Stack;

public class Decode_String {

    public String decodeString(String s) {

        Stack<Integer> count = new Stack<>();
        Stack<String> stack = new Stack<>();

        String current = "";
        String prev = "";
        int k=0;


        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){

                k= ch - '0';
            }

            else if(ch == '['){

                count.push(k);
                stack.push(current);
                current = "";
                k=0;

            }

            else if(ch == ']'){

                int c = count.pop();
                prev = stack.pop();

                for(int j=0;j<c;j++){
                    prev = prev + current;
                }

                current=prev;
            }

            else{
                current+=ch;
            }
        }

        return current;

    }

    public static void main(String[] args){

        Decode_String ds = new Decode_String();
        System.out.println(ds.decodeString("3[a2[c]]"));
    }
}
