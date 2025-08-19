package DSA;

public class Reaching_Points {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) return true;

            if (tx == ty) break; // No progress if both are equal

            if (tx > ty) {
                if (ty > sy)
                    tx %= ty;
                else
                    return (tx - sx) % ty == 0;
            } else {
                if (tx > sx)
                    ty %= tx;
                else
                    return (ty - sy) % tx == 0;
            }
        }
        return tx == sx && ty == sy;
    }

    public static void main(String[] args){
        Reaching_Points rp = new Reaching_Points();
        System.out.println(rp.reachingPoints(1,1,3,5));
    }
}
