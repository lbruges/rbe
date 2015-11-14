import java.util.Scanner;

public class Matrices {
	private static int[][] base= {{2,-7,-7,-5},{-7,2,-5,-7},{-7,-5,2,-7},{-5,-7,-7,2}};
	//private static int[][] base={{2,-4,-4,-1},{-4,2,-1,-4},{-4,-1,2,-4},{-1,-4,-4,2}};
	private static int[][] u;
	private static String cad1,cad2;
	private static int delta,n,m;
	
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		cad1=input.next();
		cad2=input.next();
		delta=input.nextInt();
		
		n=cad1.length()+1;
		m=cad2.length()+1;
		
		u=new int[n][m];
		generateMatrix();
		calculate_u();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(u[i][j]+" ");
			}
			System.out.println();
		}
		
		input.close();

	}
	private static void generateMatrix() {
		for (int i = 0; i < n; i++) {
			u[i][0]=delta*i;
		}
		for (int i = 0; i < m; i++) {
			u[0][i]=delta*i;
		}
	}
	private static void calculate_u() {
		for (int j = 1; j < m; j++) {
			for (int i = 1; i < n; i++) {
				System.out.println("i-->"+i);
				System.out.println("j-->"+j);
				u[i][j]=findMax(i,j);
				//System.out.println(u[i][j]);
			}
		}
		/*
		int temp=u[n-1][m-2];
		u[n-1][m-2]=u[n-2][m-1];
		u[n-2][m-1]=temp;
		*/
	}
	
	private static int findMax(int i,int j){
		System.out.println(cad1.charAt(i-1)+" "+cad2.charAt(j-1));
		
		int n1=toInt(cad1.charAt(i-1)),m1=toInt(cad2.charAt(j-1));
		int max=Integer.MIN_VALUE;
		/*
		System.out.println(n1+" ---- "+m1);
		System.out.println(base[n1][m1]);
		System.out.println("*"+(base[n1][m1]+u[i-1][j-1]));
		System.out.println("*"+(delta+u[i-1][j]));
		System.out.println("*"+(delta+u[i][j-1]));
		*/
		if((base[n1][m1]+u[i-1][j-1])>max){
			max=base[n1][m1]+u[i-1][j-1];
			System.out.println(base[n1][m1]+"+"+u[i-1][j-1]);
		}
		if((delta+u[i-1][j])>max){
			max=delta+u[i-1][j];
			System.out.println(delta+"+"+u[i-1][j]+"i-1");
			
		}
		if((delta+u[i][j-1])>max){
			max=delta+u[i][j-1];
			System.out.println(delta+"+"+u[i][j-1]);
		}
		return max;
	}
	
	private static int toInt(char c){
		switch(c){
		case 'A':
			return 0;
		case 'G':
			return 1;
		case 'C':
			return 2;
		case 'T':
			return 3;
		default:
			return Integer.MIN_VALUE;
		}
	}

}
