package DSA.Bit_Operations;

public class Minimum_Binary_Flips {

    public int minFlips(int a, int b, int c) {

        if((a | b) == c)
            return 0;

        int a_rem = 0;
        int b_rem = 0;
        int c_rem = 0;

        int flips = 0;

        while((a!=0) || (b!=0) || (c!=0)){

            a_rem = a%2;
            b_rem = b%2;
            c_rem = c%2;

            a=a/2;
            b=b/2;
            c=c/2;

            if((a_rem | b_rem) == c_rem){
                continue;
            }

            else if( (a_rem == 1) && (b_rem == 1) && (c_rem == 0)){
                flips += 2;
            }

            else
                flips++;
        }

        return flips;

    }

    public static void main(String[] args){

        Minimum_Binary_Flips minimumBinaryFlips = new Minimum_Binary_Flips();
        System.out.println(minimumBinaryFlips.minFlips(1,2,3));
    }
}
