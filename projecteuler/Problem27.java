/**
 *
 * Problem: https://projecteuler.net/problem=27
 * 
 Quadratic primes
Problem 27
Euler discovered the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

The incredible formula  n² - 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, 79 and 1601, is 126479.

Considering quadratics of the form:

n² + an + b, where |a|  1000 and |b|  1000

where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |-4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
 */
public class Problem27 {
    public static final int LIMIT = 1000;
    public static boolean primes[] = new boolean[LIMIT*LIMIT];
    
    public static void findAllPrimes(){
        for(int i = 0; i < LIMIT; i++){
            if(!primes[i]){
                for(int j = i*2+2; j < primes.length; j += i+2){
                    primes[j] = true;
                }
            }
        }
    }
    
    public static boolean isPrime(int n){
        if(n < 0) return false;
        if(n < 2) return true;
        if(n % 2 == 0) return false;
        return !primes[n-2];
    }

    public static int longestSeq(int a, int b){
        int n = 0;
        while(true){
            int res = n*n + a*n + b;
            if(!isPrime(res)){
                break;
            }
            n++;
        }
        return n;
    }
    

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        findAllPrimes();
        
        int maxSeq = 0, finalA = 0, finalB = 0;
        for(int a = -999; a < LIMIT; a++){
            for(int b = -999; b < LIMIT; b++){
                int longest = longestSeq(a, b);
                if(longest >= maxSeq){
                    maxSeq = longest;
                    finalA = a;
                    finalB = b;
                }
            }
        }
        System.out.println(finalA*finalB);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }
}
