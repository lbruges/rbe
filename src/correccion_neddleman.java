import java.util.Scanner;

public class correccion_neddleman {
	//private static int[][] base= {{2,-10,-10,-10},{-10,2,-8,-8},{-10,-8,2,-8},{-10,-8,-8,2}};
	//private static int[][] base= {{2,-7,-7,-5},{-7,2,-5,-7},{-7,-5,2,-7},{-5,-7,-7,2}};
	private static int[][] base={{2,-4,-4,-1},{-4,2,-1,-4},{-4,-1,2,-4},{-1,-4,-4,2}};
	private static int[][] u;
	private static String cad1,cad2;
	private static int delta,n;
	private static String ans1, ans2;
	
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		ans1 = ""; 
		ans2 = "";
		cad1=input.next().toUpperCase();
		cad2=input.next().toUpperCase();
		delta=input.nextInt();
		
		n=cad1.length()+1;
		
		u=new int[n][n];
		generateMatrix();
		calculate_u();
		System.out.println("Matriz resultante");
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(u[i][j]+" ");
			}
			System.out.println();
		}
		
		stringMatching();
		
		System.out.println(ans1);
		System.out.println(ans2);
		input.close();

	}
	private static void generateMatrix() {
		for (int i = 0; i < n; i++) {
			u[i][0]=delta*i;
		}
		for (int i = 0; i < n; i++) {
			u[0][i]=delta*i;
		}
	}
	private static void calculate_u() {
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				u[i][j]=findMax(i,j);
			}
		}
		
		
		

	}
	
	private static int findMax(int i,int j){
		
		int n1=toInt(cad1.charAt(i-1)),m1=toInt(cad2.charAt(j-1));
		int max=Integer.MIN_VALUE;

		if((base[n1][m1]+u[i-1][j-1])>max){
			max=base[n1][m1]+u[i-1][j-1];
		}
		if((delta+u[i-1][j])>max){
			max=delta+u[i-1][j];
			
		}
		if((delta+u[i][j-1])>max){
			max=delta+u[i][j-1];
		}
		/*
		if(0>max){
			max=0;
		}*/
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
	
	private static void stringMatching(){
		int i = u.length - 1 ;
		int j = u[0].length - 1; 
		int up=Integer.MIN_VALUE,diag=Integer.MIN_VALUE,left=Integer.MIN_VALUE;
		
		while(i>=0 && j>=0){			
			if(i==0){					
				if(j==0) break;
				ans1 = "_" + ans1;
				ans2= cad2.charAt(j-1)+ans2;;
				j--;
			}
			else if(j==0){
					ans1 = cad1.charAt(i-1)+ans1;
					ans2="_" + ans2;
					i--;
			}
			else{
					left = u[i-1][j];
					diag = u[i-1][j-1];
					up = u[i][j-1];
					if(diag>=left && diag>=up){
						ans1 = cad1.charAt(i - 1) + ans1;
						ans2 = cad2.charAt(j - 1) + ans2;
						i--;
						j--;
					}else if(up>=left){
						ans1 = "_" + ans1;
						ans2=cad2.charAt(j-1)+ans2;
						j--;
					}else{
						ans1 =cad1.charAt(i-1)+ans1;
						ans2= "_" + ans2;
						i--;
					}
				}
			
		}
		
	}


}
