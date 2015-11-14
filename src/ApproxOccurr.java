import java.util.Scanner;

public class ApproxOccurr {
	private static String pattern,cad;
	private static int dist;
	public static void main(String[] args) {
		Scanner leer= new Scanner(System.in);
		pattern=leer.nextLine();
		cad=leer.nextLine();
		dist=leer.nextInt();
		calculateAprox();
		leer.close();

	}
	
	private static void calculateAprox() {
		for (int i = 0; i < cad.length()-pattern.length()+1; i++) {
			if(hammingDistance(cad.substring(i, i+pattern.length()), pattern)<=dist){
				System.out.println(i);
			}
		}
		
	}

	private static int hammingDistance(String cad1,String cad2) {
		int d=0;
		for (int i = 0; i < cad1.length(); i++) {
			if(cad1.charAt(i)!=cad2.charAt(i)){
				d++;
			}
		}
		return d;
	}

}
