/**
 *
 * 
 */
public class Problem10 {
    
    public static long sumOfPrimes(int n){
        long r = 0;
        
        boolean sieve[] = new boolean[n];
        int root = (int) Math.ceil(Math.sqrt(n));
        for(int i = 0; i < root; i++){
            if(!sieve[i]){
                for(int j = i*2+2; j < n; j += i+2){
                    sieve[j] = true;
                }
            }
        }
        sieve[0] = false;
        
        for(int i = 0; i < n; i++){
            if(!sieve[i] && i+2 < n){
                r += (i+2);
            }
        }
        
        return r;
    }
    
    
    public static void main(String args[]){
        System.out.println(sumOfPrimes(2000000));
    }
    
}
