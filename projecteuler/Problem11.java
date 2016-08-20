import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * Problem: https://projecteuler.net/problem=11
 */
public class Problem11 {
    public static final int SIZE = 20;
    public static int[][] matrix = new int[SIZE][SIZE];
    public static final int SEQ = 4;

    
    
    public static long findLargestProduct(){
        // product rows, columns, diagonal.
        long greatest = 0;
        //Horizontal
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j <= SIZE - SEQ; j++){
                
                long product = 1;
                for(int k = 0; k < SEQ; k++){
                    product *= matrix[i][j+k];
                }
                greatest = Math.max(greatest, product);
            }
        }
        
        //Vertical
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j <= SIZE - SEQ; j++){
                long product = 1;
                for(int k = 0; k < SEQ; k++){
                    product *= matrix[j+k][i];
                }
                greatest = Math.max(product, greatest);
            }
        }
        
        // Diagonal \\\\\
        for(int i = 3; i < 2 * SIZE; i++){
            for(int j = (i/SIZE)*i%SIZE, auxi = i>=SIZE? SIZE-1: i;
                    j <= i + 1 - SEQ && j <= SIZE - SEQ;
                    j++){
                long product = 1;
                
                for(int k = 0; k < 4; k++){
                    int a = matrix[auxi-k][j+k];
                    product *= a;
                }
                greatest = Math.max(product, greatest);
                auxi--;
            }
        }
        
        return greatest;
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("src/ProblemSolving/ProjectEuler/problem11.in"));
        
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                matrix[i][j] = input.nextInt();
            }
        }        
        input.close();
        
        System.out.println(findLargestProduct());
    }
}
