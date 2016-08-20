
import java.util.HashSet;

/**
 * http://projecteuler.net/problem=23
 Non-abundant sums
Problem 23
A perfect number is a number for which the sum of its proper divisors is exactly
* equal to the number. For example, the sum of the proper divisors of 28 would 
* be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n 
* and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest 
* number that can be written as the sum of two abundant numbers is 24. By 
* mathematical analysis, it can be shown that all integers greater than 28123 
* can be written as the sum of two abundant numbers. However, this upper limit 
* cannot be reduced any further by analysis even though it is known that the 
* greatest number that cannot be expressed as the sum of two abundant numbers is
* less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of 
* two abundant numbers.
 */
public class Problem23 {

    public static HashSet<Integer> abundant = new HashSet<>();
    
    public static int sumFactors(int n){
        int factors = 1;
        if(n == 1) return 1;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++){
            if(n % i == 0){
                factors += i;
                int div = n/i;
                if(div != i)
                    factors += div;
            }
        }
        return factors; // Perfect numbers
    }
    
    public static void main(String[] args) {
        int factors, sum = 0, limit = 28123;
        long start = System.currentTimeMillis();
        //Obtain all abundant numbers
        for(int i = 1; i <= limit; i++){
            if(abundant.contains(i)) {continue;}
            factors = sumFactors(i);
            if(factors > i){ // Abundant
                abundant.add(i);
            }
        }
        
        //This will save all numbers that can be written as the sum of 2 abundnt
        boolean[] allAbundantNumbers = new boolean[limit+1];
        for(Integer i : abundant){
            for(Integer j : abundant){
                if(i+j <= limit)
                allAbundantNumbers[i+j] = true;
            }
        }
        
        for(int i = 1; i <= limit; i++){
            if(!allAbundantNumbers[i]){
                sum += i;
            }
        }
        System.out.println(sum); // 4179871
        System.out.printf("Completed in: %d milliseconds.\n", System.currentTimeMillis()-start);
    }
}
