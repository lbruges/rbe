
import java.util.Scanner;

public class Dynamic3N1 {

	public static String[] arr;
	public static void main(String[] args) {
		arr=new String[1000];
		arr[0]="0 ";
		arr[1]="1 ";
		Scanner leer= new Scanner(System.in);
		int n=leer.nextInt();
		while(n>0){			
			tresnmasuno(n);
			System.out.println(arr[n]);
			n=leer.nextInt();
			//showCalc();
		}
		leer.close();

	}
	/*
	private static void showCalc() {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=null){
				System.out.print(i+"-");
			}
		}
		System.out.println();
		
	}*/

	private static void tresnmasuno(int n){
		int n_0=n;
		if(arr[n]==null){
			String temp=n+" ";
			int last_n=n;
			while (n>1||arr[n]==null) {
				if(n%2==0){
					temp+=(n/2)+" ";									
					n=n/2;					
				}else{
					temp+=(3*n+1)+" ";					
					n=3*n+1;
				}
				last_n=n;
			}
			
			if(last_n!=1){
				arr[n_0]+=arr[last_n];
			}else{
				arr[n_0]=temp;
				for (int i = 1; i < temp.length(); i++) {
					if(temp.charAt(i)!=' '){						
						String temp1=temp.substring(i, temp.indexOf(' ', i));
						int temp_int=Integer.parseInt(temp1);
						if(arr[temp_int]==null){
							arr[temp_int]=temp.substring(i);
						}
						
					}
					
				}
			}
			
		}
	}
	
	

}
