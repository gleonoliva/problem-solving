package ProblemSolving.ProjectEuler;

import java.math.BigInteger;

/**
 * Problem: http://projecteuler.net/problem=48
 * 
* Self powers
Problem 48
The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
 */
public class Problem48 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        BigInteger sum = BigInteger.ZERO;
        BigInteger mod = BigInteger.valueOf(10_000_000_000L);
        for(int i = 1; i <= 1000; i++){
            BigInteger bi = BigInteger.valueOf(i);
            sum = sum.add(bi.modPow(bi, mod));
        }
        sum = sum.mod(mod);
        System.out.println(sum);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
