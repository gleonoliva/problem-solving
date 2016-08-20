
/**
 * Problem: http://projecteuler.net/problem=7
 */
public class Problem7 {
    
    public static long getPrime(long primeNumber){
        long r = 1;
        long limit = primeNumber * primeNumber;
        long hop = 2;
        
        boolean []sieve = new boolean[(int)limit];
        
        int c = 0;
        
        for(int i = 0; i < primeNumber; i++){
            if(!sieve[i]){
                for(int j = i*2+2; j < limit; j += i+2){
                    sieve[j] = true;
                }
            }
        }
        sieve[0] = false;
        
        for(int i = 0; i < limit; i++){
            if(!sieve[i]){
                c++;
                if(c == primeNumber) return i+2;
            }
        }
        
        
        return 0;
    }
    
    
    public static void main(String[] args){
        System.out.println(getPrime(10001));
    }
}
