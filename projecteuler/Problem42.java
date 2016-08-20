package ProblemSolving.ProjectEuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * Problem: http://projecteuler.net/problem=42
 * 
Coded triangle numbers
Problem 42
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); 
* so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its 
* alphabetical position and adding these values we form a word value. 
* For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word 
* value is a triangle number then we shall call the word a triangle word.
 */
public class Problem42 {

    public static int sumChars(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += s.charAt(i)-'A'+1;
        }
        return sum;
    }
    
    public static boolean isTriangular(int n){
        double sqrt = Math.sqrt(n*2.0);
        int ceil = (int) Math.ceil(sqrt);
        int floor = (int) Math.floor(sqrt);
        return ceil * floor == n*2;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        Scanner in = new Scanner(new File("src/ProblemSolving/ProjectEuler/problem42.in"));
        in.useDelimiter(",");
        int count = 0;
        int triangulars[] = new int[100];
        triangulars[0] = 1;
        for(int i = 1; i < triangulars.length; i++){
            triangulars[i] = triangulars[i-1] + i + 1;
        }
        while(in.hasNext()){
            String s = in.next();
            s = s.substring(1, s.length() - 1);
            if(Arrays.binarySearch(triangulars, sumChars(s)) >= 0){
                count++;
            }
        }
        in.close();
        System.out.println(count);
        System.out.printf("Completed in: %d milliseconds.\n", (System.currentTimeMillis()-start));
    }

}
