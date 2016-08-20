/**
 *
 * Problem: http://projecteuler.net/problem=43
 * 
 Sub-string divisibility
Problem 43
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of 
* each of the digits 0 to 9 in some order, but it also has a rather interesting 
* sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, 
* we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem43 {

    public static void swap(char[] a, int x, int y){
        char t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
    
    public static void reverse(char[] arr, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            swap(arr, i, j);
        }
    }
    
    public static long nextPerm(long n){
        char []array = Long.toString(n).toCharArray();
        int i = 0, k = -1;
        for(;i < array.length -1; i++)
            if(array[i] < array[i+1])
                k = i;
        // If k == -1 no next perm;
        if(k == -1) return k;
        
        int l = k+1;
        for(i = k+1; i < array.length; i++){
            if(array[k] < array[i]){
                l = i;
            }
        }

        swap(array, k, l);
        
        reverse(array, k+1, array.length-1);
        
        return Long.parseLong(String.copyValueOf(array));
    }

    public static int getDigits(long n, int start, int digits){
        String s = Long.toString(n);
        return Integer.parseInt(s.substring(start, start+digits));
    }
            
    public static void main(String[] args) {
        int[] primes = new int[]{2,3,5,7,11,13,17};
        
        long first = 123456789;
        long next = 1023456789;
        long sum = 0;
        while(next != -1){
        
            boolean is = true;
            for(int i = 0; i < primes.length; i++){
                int d = getDigits(next, i+1, 3);
                if(d % primes[i] != 0) {
                    is = false;
                    break;
                }
            }
            
            if(is){
                sum += next;
            }
            next = nextPerm(next);
            
        }
        System.out.println(sum);
    }
}
