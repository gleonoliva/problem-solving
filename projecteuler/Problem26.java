
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.TreeSet;

/**
 *Problem: http://projecteuler.net/problem=26
 Reciprocal cycles
Problem 26
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d  1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Problem26 {
    
    public static int cycle(int n){
        TreeSet<Integer> remainders = new TreeSet<Integer>();
        int m = 1, cont = 0;
        
        while(m < n){
            m *= 10;
        }
        do{
            while(m < n){
                m *= 10;
                cont++;
            }
            if(remainders.contains(m)){
                break;
            }
            remainders.add(m);
            m = m % n;
        }while(m != 0);

        return cont;
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int dmax = 0, max = 0;
        for(int i = 1; i < 1000; i++){
            int c = cycle(i);
            if(c > max){
                max = c;
                dmax = i;
            }
        }
        System.out.printf("%d: %d\n", dmax, max);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }
}
