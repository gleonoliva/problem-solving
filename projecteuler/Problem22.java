
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Problem: https://projecteuler.net/problem=22
 */
public class Problem22 {

    
    public static int getScore(String s){
        int sum = 0;
        for(char c : s.toCharArray()){
            sum += c - 'A' + 1;
        }
        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("problem22.in"));
        
        ArrayList<String> memory = new ArrayList<>(6000);
        
        in.useDelimiter(",");
        while(in.hasNext()){
            String s = in.next();
            s = s.substring(1, s.length()-1);
            memory.add(s);
        }
        
        Object[] names = memory.toArray();
        Arrays.sort(names);
        
        long sum = 0;
        for(int i = 0; i < names.length; i++){
            sum += getScore(names[i].toString()) * (i+1);
        }
        System.out.println(sum);
    }
}
