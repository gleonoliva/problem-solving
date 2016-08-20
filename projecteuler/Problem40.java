package ProblemSolving.ProjectEuler;

/**
 *
 * Problem: http://projecteuler.net/problem=40
 * 
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 x d10 x d100 x d1000 x d10000 x d100000 x d1000000
 */
public class Problem40 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= 1000_000; i++){
            sb.append(Integer.toString(i));
        }
        String s = sb.toString();
        int res = 1;
        for(int i = 1; i <= 1000_000; i *= 10){
            res *= (s.charAt(i-1) - '0');
        }
        System.out.println(res);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
