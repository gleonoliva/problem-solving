/**
 *
 * http://projecteuler.net/problem=28
Number spiral diagonals
Problem 28
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class Problem28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 1;
        for(int i = 3, j = 2; j < 1001;){
            long sumRect = 4*i + 6*j;
            sum += sumRect;
            i += 3 * j + (j+2);
            j+=2;
        }
        System.out.println(sum);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }
}
