import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MortalFibonacciRabbits {
	private static BigInteger[] rabbits;
	private static boolean[] flags;
	private static Scanner input;
	private static int n,m;
	
	public static void main(String[] args) {
		input=new Scanner(System.in);
		n=input.nextInt();
		m=input.nextInt();
		mortal();
		
	}
	
	public static void mortal(){
		BigInteger[] temp= new BigInteger[m];
		for (int i = 0; i < temp.length; i++) {
			temp[i]=BigInteger.ZERO;
		}
		
		temp[0]=BigInteger.ONE;
		
		/*
		 * for (int i = arr.length-1; i > 0; i--) {
			arr[i]=arr[i-1];
			arr[0]+=arr[i];
		}
		 * */
		
		for (int i = 1; i < n; i++) {
			System.out.println(Arrays.toString(temp));
			//1+2
			for (int j = 1; j < temp.length; j++) {
				temp[0]=temp[0].add(temp[j]);
			}
			for (int j = temp.length-1; j > 0; j--) {
				temp[j]=temp[j-1];
			}
			temp[0]=BigInteger.ZERO;
			
			
			
			
			
		}
		
		BigInteger res=BigInteger.ZERO;
		for (int i = 0; i < temp.length; i++) {
			res=res.add(temp[i]);
		}
		System.out.println(res);
	}
	/*
	private static void imprimirSubArray(int n){
		for (int i = 0; i <= n; i++) {
			System.out.print(rabbits[i]+"  ");
		}
		System.out.println();
	}
	
	private static void imprimirSubArrayBool(int n){
		for (int i = 0; i <= n; i++) {
			System.out.print(flags[i]+"  ");
		}
		System.out.println();
	}*/

}
