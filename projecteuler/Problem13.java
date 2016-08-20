import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * Problem: https://projecteuler.net/problem=13
 */
public class Problem13 {
    
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("problem13.in"));
        
        BigInteger bi = BigInteger.ZERO;
        while(input.hasNext()){
            bi = bi.add(input.nextBigInteger());
        }
        System.out.println(bi.toString().substring(0, 10));
    }
}
