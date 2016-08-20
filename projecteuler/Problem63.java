
import java.math.BigInteger;

/**
http://projecteuler.net/problem=63
Powerful digit counts
Problem 63
The 5-digit number, 16807=7^5, is also a fifth power. Similarly, 
* the 9-digit number, 134217728=8^9, is a ninth power.

How many n-digit positive integers exist which are also an nth power?
 */
public class Problem63 {
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        int count = 0;
        int limit = 1000;
        for(long i = 1; i < limit; i++)
            for(int j = 1;j < limit;j++){
                BigInteger bi = BigInteger.valueOf(i);
                BigInteger pow = bi.pow(j);
                String powString = pow.toString();
                int dig = powString.length();
                if(dig == j){
                    count++;
                    System.out.printf("%d^%d: %s (%d)\n", i, j, powString, dig);
                } else{
                    break;
                }
            }
        
        System.out.println(count);
        
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
