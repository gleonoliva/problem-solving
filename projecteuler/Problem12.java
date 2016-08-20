import java.util.ArrayList;

/**
 * Problem: https://projecteuler.net/problem=12
Highly divisible triangular number
Problem 12
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
 */
public class Problem12 {
    
    public static long countFactors(long n){
        int factors = 0;
        if(n == 1) return 1;
        int sqrt = (int)Math.ceil(Math.sqrt(n));
        for(int i = 1; i < sqrt; i++){
            if(n % i == 0){
                factors += 2;
            }
        }
        return factors;
    }
    
    public static void printFactors(long n){
        int sqrt = (int)Math.ceil(Math.sqrt(n));
        for(int i = 1; i < sqrt; i++){
            if(n % i == 0){
                System.out.println(i);
                System.out.println(n/i);
            }
        }
    }
    
    public static void main(String[] args){
        long factors = 0;
        long c = 1, start = 1;
        long timeStart = System.currentTimeMillis();
        while(factors < 500){
            factors = countFactors(c);
            c += ++start;
        }
        c -= start;
        System.out.println(c);
        System.out.println(System.currentTimeMillis() - timeStart);
    }
}