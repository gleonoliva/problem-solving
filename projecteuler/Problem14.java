package ProblemSolving.ProjectEuler;

import java.util.Scanner;

/**
 * Problem: https://projecteuler.net/problem=14
 */
public class Problem14 {
    
    public static void main(String[] args){
        long start = System.currentTimeMillis();
       
        long longestSeq = 0;
        long startLong = 0;
        for(long i = 2;i < 1000_000; i++){
            long n = i;
            long c = 0;
            while(n != 1){
                if((n & 1) == 1){
                    n = 3 * n + 1;
                } else {
                    n = n >> 1;
                }
                c++;
            }
            if(c > longestSeq){
                longestSeq = c;
                startLong = i;
            }
        }
        System.out.println(startLong);
        System.out.printf("Completed in %d milliseconds.\n", (System.currentTimeMillis() - start));
    }
}
