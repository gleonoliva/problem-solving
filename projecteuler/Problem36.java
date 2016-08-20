package ProblemSolving.ProjectEuler;

import java.util.Arrays;

/**
 *
 * Problem: http://projecteuler.net/problem=36
 */
public class Problem36 {

    public static boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0, j = len - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    
    public static long nextPalindrome(long n){
        char []c = Long.toString(n).toCharArray();
        int i = c.length >> 1;
        int j = (c.length % 2 == 0)? i-1:i;
        boolean last = false;
        while(i < c.length){
            if(c[i] == '9'){
                c[i++] = c[j--] = '0';
                last = true;
            } else {
                if(j != i){
                    c[j]++;
                }
                c[i]++;
                last = false;
                break;
            }
        }
        if(last){
            char r[] = new char[c.length+1];
            Arrays.fill(r, '0');
            r[0] = '1';
            r[r.length - 1] = '1';
            return Long.parseLong(new String(r));
        }
        return Long.parseLong(new String(c));
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for(long number = 0; number < 1000000;){
            number = nextPalindrome(number);
            if(isPalindrome(Long.toBinaryString(number))){
                sum += number;
            }
        }
        System.out.println(sum);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
