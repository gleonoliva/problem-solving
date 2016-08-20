package ProblemSolving.ProjectEuler;

import java.util.HashSet;

/**
 * Problem: https://projecteuler.net/problem=21
 Amicable numbers
Problem 21
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 {

    public static int findDivisorsSum(int n){
        int sum = 0;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 1; i < sqrt; i++){
            if(n % i == 0){
                sum += i;
                sum += (n / i); // This means we found 2 factors at once.
            }
        }
        sum -= n;
        return sum;
    }
    
    public static void main(String[] args) {
        int amicableSum = 0;
        for(int i = 220; i < 10000; i++){
            int pair1 = findDivisorsSum(i);
            if(pair1 < i) continue;
            int pair2 = findDivisorsSum(pair1);
            if(pair2 == i && i != pair1){ // Finding perfect numbers
                // Amicable pair! :D
                amicableSum += (pair1 + i);
            }
        }
        
        System.out.println(amicableSum);
    }
}
