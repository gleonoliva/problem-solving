
import java.util.HashMap;

/**
 * 
 * Problem: http://projecteuler.net/problem=31
 * 
Coin sums
Problem 31
In England the currency is made up of pound, £, and pence, p, and there are 
* eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1£1 + 150p + 220p + 15p + 12p + 31p
How many different ways can £2 be made using any number of coins?
 */
public class Problem31 {
    
    public static HashMap<String, Long> memory = new HashMap<>();
    public static int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};
    
    public static long makeChange(int cents, int denom){
        if(denom == coins.length-1) return 1;
//        Long s = memory.get(String.format("%d,%d", cents, denom));
//        if(s != null){
//            return s.longValue();
//        }
        
        long ways = 0;
        for(int i = 0; i * coins[denom] <= cents; i++){
            ways += makeChange(cents - (i * coins[denom]), denom+1);
        }
//        memory.put(String.format("%d,%d", cents, denom), ways);
        return ways;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int cents = 200; // 2 pounds.
        System.out.println(makeChange(200, 0));
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }
}