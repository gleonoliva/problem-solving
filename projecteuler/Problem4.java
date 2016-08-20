
/**
 *
 * Problem: http://projecteuler.net/problem=4
 */
public class Problem4 {
    
    public static boolean isPalindrome(int n){
        String s = ""+n;
        
        for(int i = 0, j = s.length()-1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        
        return true;
    }
    
    public static int findLargestPalindrome(){
        int a = 999;
        int b = 999;
        int c;
        // Linear search YOLO
        do {
            c = a * b;
            if(b == 900){
                b = a;
                a--;
            } else {
                b--;
            }
            c = a * b;
        } while(!isPalindrome(c));
        return a * b;
    }
    
    public static void main(String[] args){
        System.out.println(findLargestPalindrome());
    }
    
}
