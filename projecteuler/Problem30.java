
/**
 * Problem: http://projecteuler.net/problem=30
Digit fifth powers
Problem 30
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 {

    public static long[] pows = new long[10];
    
    public static long sumDigits(int n){
        long sum = 0;
        while(n > 0){
            int digit = n%10;
            sum += pows[digit];
            n /= 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int LIMIT = 200000;
        
        for(int i = 0; i < pows.length; i++){
            pows[i] = (long) Math.pow(i, 5);
        }
        
        long sum = 0;
        for(int i = 2; i < LIMIT; i++){
            long sumDig = sumDigits(i);
            if(i == sumDig){
                sum+= i;
            }
        }
        System.out.println(sum);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
        System.out.println(Long.MAX_VALUE);
    }
}
