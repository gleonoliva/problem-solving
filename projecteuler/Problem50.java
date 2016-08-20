package ProblemSolving.ProjectEuler;

import static ProblemSolving.ProjectEuler.Problem27.LIMIT;
import static ProblemSolving.ProjectEuler.Problem27.primes;
import java.util.ArrayList;

/**
 *
 * Problem: http://projecteuler.net/problem=50
 * 
Consecutive prime sum
Problem 50
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below
* one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, 
* contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most 
* consecutive primes?
 */
public class Problem50 {

    public static final int LIMIT = 1000000;
    public static boolean primes[] = new boolean[LIMIT];
    public static ArrayList<Integer> primeList = new ArrayList<>();
    
    public static void findAllPrimes(){
        int i = 0;
        int lilLimit = (int) Math.sqrt(LIMIT);
        for(i = 0; i < lilLimit; i++){
            if(!primes[i]){
                primeList.add(i+2);
                for(int j = i*2+2; j < primes.length; j += i+2){
                    primes[j] = true;
                }
            }
        }
        for(; i < LIMIT-2; i++){
            if(!primes[i]){
                primeList.add(i+2);
            }
        }
    }
    
    public static boolean isPrime(int n){
        if(n > 2 && n < LIMIT-1){
            return !primes[n-2];
        }
        return false;
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        findAllPrimes();
        int lastPrime = primeList.get(primeList.size()-1);
        int i = 0, j = 1;
        int maxi = 0, maxj = 0;
        int maxGap = 0;
        
        int currentSum = primeList.get(i) + primeList.get(j++);
        int maxSum = 0;
        while(i <= (primeList.size() >> 1)){
            if(currentSum + primeList.get(j) <= lastPrime){
                currentSum += primeList.get(j);
            } else {
                i++;
                j = i+1;
                currentSum = primeList.get(i)+primeList.get(j++);
                continue;
            }
            if(isPrime(currentSum) && j - i> maxGap){
                maxi = i;
                maxj = j;
                maxGap = j - i;
                maxSum = currentSum;
            }
            j++;
        }
        System.out.println(maxSum);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
