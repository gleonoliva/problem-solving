
import java.util.Arrays;

/**
 *
 * Problem: http://projecteuler.net/problem=34
 * 
Digit factorials
Problem 34
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem34 {

    public static long sumDigits(long[] a, int n){
        long sum = 0;
        while(n > 0){
            int d = n % 10;
            sum += a[d];
            n /= 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        long factorials[] = new long[10];
        factorials[0] = 1;
        for(int i = 1; i < factorials.length; i++){
            factorials[i] = factorials[i-1]*i;
        }
        
        long limit = 9;
        long maxSum = factorials[factorials.length-2];
        while(limit < maxSum){
            limit *= 10;
            limit += 9;
            maxSum += factorials[factorials.length-2];
        }
        
        long total = 0;
        for(int i = 3;i < limit; i++){
            long sum = sumDigits(factorials, i);
            if(i == sum){
                total += i;
            }
        }
        
        System.out.println(total);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
