/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemSolving.ProjectEuler;

import java.math.BigInteger;

/**
 * http://projecteuler.net/problem=56
Powerful digit sum
Problem 56
A googol (10100) is a massive number: one followed by one-hundred zeros; 100^100
is almost unimaginably large: one followed by two-hundred zeros. Despite their 
size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, a^b, where a, b < 100, what is the 
maximum digital sum?
 */
public class Problem56 {

    public static long sumDigits(BigInteger bi){
        long sum = 0;
        for(char c : bi.toString().toCharArray()){
            sum += c - '0';
        }
        return sum;
    }
    
    
    public static void main(String[] args) {
        long maxSum = 0;
        for(int a = 2; a < 100; a++){
            for(int b = 2; b < 100; b++){
                long sum = sumDigits(new BigInteger(""+a).pow(b));
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        System.out.println(maxSum);
    }
}
