
import java.util.Arrays;

/**
 * Problem: https://projecteuler.net/problem=24
 * 
A permutation is an ordered arrangement of objects. For example, 3124 is one 
* possible permutation of the digits 1, 2, 3 and 4. If all of the permutations 
* are listed numerically or alphabetically, we call it lexicographic order. 
* The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits
* 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem24 {

    public static int permNo = 0;
    
    public static String printArray(int []a){
        String s = "";
        for(int i : a){
            s +=i;
        }
        return s;
    }
    
    public static void swap(int []a, int x, int y){
        int c = a[x];
        a[x] = a[y];
        a[y] = c;
    }
    
    public static void findAllPermutations(int []a, int k){
        if(k == a.length-1){
            System.out.println(printArray(a));
        } else {
            for(int i = k; i < a.length; i++){
                swap(a, k, i);
                findAllPermutations(a, k+1);
                swap(a, k, i);
            }
        }
    }
    
    public static void reverse(int a[], int start){
        for(int i = start, j = a.length-1; i < j; i++, j--){
            swap(a, i, j);
        }
    }
    
    public static boolean nextPerm(int a[]){
        int k = -1;
        for(int i = 0; i < a.length-1; i++){
            if(a[i] < a[i+1]){
                k = i;
            }
        }
        if(k < 0 || k >= a.length) return false;
        int l = k + 1;
        for(int j = l; j < a.length; j++){
            if(a[k] < a[j]){
                l = j;
            }
        }
        swap(a, k, l);
        reverse(a, k+1);
        return true;
    }
    
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        for(int i = 2; i <= 1000000; i++){
            nextPerm(array);
        }
        System.out.println(printArray(array));
    }
}
