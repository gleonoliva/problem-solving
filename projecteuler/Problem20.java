
import java.math.BigInteger;

/**
 *
 * Problem: https://projecteuler.net/problem=20
 */
public class Problem20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int limit = 100;
        
        BigInteger bi = new BigInteger("2");
        
        for(int i = bi.intValue()+1; i <= limit; i++){
            bi = bi.multiply(new BigInteger(""+i));
        }
        
        int sum = 0;
        for(char c : bi.toString().toCharArray()){
            sum += c - '0';
        }
        System.out.println(sum);
    }
}
