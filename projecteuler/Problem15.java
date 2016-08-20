/**
 * Problem: https://projecteuler.net/problem=15
Lattice paths
Problem 15
Starting in the top left corner of a 22 grid, and only being able to move to 
* the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20x20 grid?
 */
public class Problem15 {
    
    public static void main(String args[]){
        int size = 20;
        
        long m[][] = new long[size][size];
        
        int j = 2;
        for(int i = 0; i < m.length; i++, j++){
            m[0][i] = j;
            m[i][0] = j;
        }
        
        for(int i = 1; i < m.length; i++){
            for(j = 1; j < m.length; j++){
                m[i][j] = m[i-1][j] + m[i][j-1];
            }
        }
        
        System.out.println(m[size-1][size-1]);
    }
    
}
