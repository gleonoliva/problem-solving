
import java.math.BigInteger;

/**
 *
 * Problem: https://projecteuler.net/problem=16
 */
public class Problem16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BigInteger i = new BigInteger("1");
        int pow = 1000;
        i = i.shiftLeft(pow);
        long n = 0;
        String number = i.toString();
        for(char c : number.toCharArray()){
            n += c - '0';
        }
        System.out.println(n);
        System.out.printf("Completed in %d milliseconds.\n", System.currentTimeMillis()-start);
    }
}
