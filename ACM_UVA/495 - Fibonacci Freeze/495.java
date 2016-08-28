import java.io.*;
import java.util.*;
import java.math.*;

public class 495{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int L = 0;		
		BigInteger fib[] = new BigInteger[5001];
		fib[0] = new BigInteger("0");
		fib[1] = new BigInteger("1");
		for(int i = 2; i < 5001; i++){
			fib[i] = fib[i-1].add(fib[i-2]);
		}			
		while(input.hasNext()){
			L = input.nextInt();
			System.out.println("The Fibonacci number for "+L+" is " + fib[L]);
		}
	}
}
