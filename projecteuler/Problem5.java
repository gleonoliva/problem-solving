/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemSolving.ProjectEuler;

/**
 *
 * Problem: http://projecteuler.net/problem=5
 * 
 */
public class Problem5 {
    
    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public static long lcm(long a, long b){
        return (a * b)/gcd(a, b);
    }
    
    public static long lcmRange(int a, int b){
        long r = 1;
        for(long i = a; i <= b; i++){
            r = lcm(i, r);
        }
        return r;
    }
    
    public static void main(String args[]){
        System.out.println(lcm(12, 4));
        System.out.println(lcmRange(1, 20));
    }
    
}
