
import hastables.HashTable;

/**
 * Problem: http://projecteuler.net/problem=9
 */
public class Problem9 {
    
    public static boolean arePythagorean(long a, long b, long c){
        return (a*a + b*b) == c*c;
    }
    
    public static long findProduct(){
        long a = 333;
        long b = 333;
        long c = 334;
        long i = 334;
        
        while(!arePythagorean(a, b, c)){
            if(c == 0){
                a--;
                b = i;
                c = 1000 - b - a;
            }
            b++; c--;
        }
        // System.out.println(String.format("a: %s | b: %s | c: %s\n", a, b, c));
        return a*b*c;
    }
    
    
    public static void main(String[] args){
        System.out.println(findProduct());
    }
}
