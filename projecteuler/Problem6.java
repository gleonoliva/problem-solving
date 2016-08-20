
/**
 *
 * Problem: http://projecteuler.net/problem=6
 * 
 */
public class Problem6 {
    
    public static long sumOfSquares(int limit){
        int r = 0;
        for(int i = 1; i <= limit; i++){
            r += i*i;
        }
        return r;
    }
    
    public static long squareOfSum(int limit){
        int mul = limit + 1;
        int root = (limit/2) * mul;
        return root * root;
    }
    
    
    public static void main(String[] args){
        int limit = 100;
        System.out.println(squareOfSum(limit) - sumOfSquares(limit));
    }
}
