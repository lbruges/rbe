import java.util.Scanner;

public class MendelLaw {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);//k= homogeneos dominante, n=recesivo, m=het
		int k=input.nextInt(),n=input.nextInt(),m=input.nextInt();
		System.out.println(probabilidad(k, m, n));
		
		input.close();

	}
	
	public static double probabilidad(int k,int m,int n){
		return ((k*k-k)+2*(k*m)+2*(k*n)+(0.75*(m*m-m))+2*(0.5*m*n))/((k+m+n)*(k+m+n-1));
	}
	//((k*k-k)+2*(k*m)+2*(k*n)+(0.75*(m*m-m))+2*(0.5*m*n))/((k+m+n)*(k+m+n-1))
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
