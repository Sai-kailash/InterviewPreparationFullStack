package DSA.Sliding_Window;

public class Defuse_Bomb {

    public int[] decrypt(int[] codes, int k) {


        int n = codes.length;

        if(k == 0){
            return new int[n];
        }

        int[] code = new int[2*n];

        for(int i=0;i<n;i++){
            code[i] = codes[i];
        }

        int pos = 0;
        if(k < 0){
            pos = n-1;
        }
        else{
            pos = 1;
        }

        for(int i=n;i<2*n;i++){
            code[i] = code[i-n];
        }

        int count = 0;
        int sum = 0;

        while(count < Math.abs(k)){

            if(pos == -1){
                pos = n-1;
            }

            else if(pos == n){
                pos = 0;
            }

            if(k < 0){
                sum += code[pos];
                pos--;
            }

            else if(k > 0){
                sum += code[pos];
                pos++;
            }

            count++;
        }

        int start;
        if(k<0){
            start = n+1;
            pos = n + k;
        } else{
            start = 1;
        }

        int[] res = new int[n];
        res[0] = sum;

        for(int i=start;i<(start+n-1);i++){
            if(k > 0){
                res[i] = sum - code[i] + code[pos];
                sum = res[i];
            }
            else if(k < 0){
                res[i-start+1] = sum - code[pos] + code[i-1];
                sum = res[i-start+1];
            }
            pos++;
        }
        return res;

    }

    public static void main(String[] args){

        int[] codes = new int[]{2,4,9,3};
        Defuse_Bomb b = new Defuse_Bomb();
        b.decrypt(codes, -2);
    }
}
