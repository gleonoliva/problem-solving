
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Problem: https://projecteuler.net/problem=18
 */
public class Problem18 {

    /**
     * @param args the command line arguments
     */
    
    public static final int SIZE = 100;
    public static int m[][] = new int[SIZE][SIZE];
    
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner input = new Scanner(new File("src/ProblemSolving/ProjectEuler/problem18.in"));
        Scanner input = new Scanner(new File("src/ProblemSolving/ProjectEuler/problem67.in"));
        
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j <= i; j++){
                m[i][j] = input.nextInt();
            }
        }

        long greatest = 0;
        for(int j = 0; j < SIZE; j++){
            for(int i = j; i < SIZE && m[i][j] != 0; i++){
                if(j == 0){
                    if(i == 0) continue;
                    m[i][j] += m[i-1][j];
                    continue;
                }
                int a = m[i-1][j-1] + m[i][j];
                int b = m[i-1][j] + m[i][j];
                m[i][j] = Math.max(a, b);
                greatest = Math.max(greatest, m[i][j]);
            }
        }
        System.out.println(greatest);
    }
}
