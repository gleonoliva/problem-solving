package ProblemSolving.ProjectEuler;

import java.math.BigInteger;

/**
 *
 * Problem: https://projecteuler.net/problem=100
Arranged probability
Problem 100
If a box contains twenty-one coloured discs, composed of fifteen blue discs and 
* six red discs, and two discs were taken at random, it can be seen that the 
* probability of taking two blue discs, P(BB) = (15/21)(14/20) = 1/2.

The next such arrangement, for which there is exactly 50% chance of taking two 
* blue discs at random, is a box containing eighty-five blue discs and 
* thirty-five red discs.

By finding the first arrangement to contain over 10^12 = 1,000,000,000,000 discs 
* in total, determine the number of blue discs that the box would contain.
 */
public class Problem100 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        BigInteger n = new BigInteger("1000000000000");
        BigInteger x = n.shiftRight(2);
        BigInteger i = BigInteger.ZERO;
        BigInteger s = n;
        BigInteger last = BigInteger.ZERO;
        
        BigInteger muln = n.multiply(n.subtract(BigInteger.ONE));
        while(true){
            BigInteger mulx = x.multiply(x.subtract(BigInteger.ONE));
            
            if(mulx.shiftLeft(1).compareTo(muln) == 0){
                break;
            } else if(mulx.shiftLeft(1).compareTo(muln) > 0) {
                s = x;
                x = i.add(x).shiftRight(1);
            } else {
                i = x;
                x = x.add(s).shiftRight(1);
            }
            if(x.compareTo(last) == 0){
                i = BigInteger.ZERO;
                n = n.add(BigInteger.ONE);
                last = BigInteger.ZERO;
                x = n.shiftRight(1);
                muln = n.multiply(n.subtract(BigInteger.ONE));
            } else {
                last = x;
            }
        }
        System.out.println(x);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
