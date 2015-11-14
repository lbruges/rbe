import java.util.Scanner;

public class HammingDistance {
	private static String cad1,cad2;
	public static void main(String[] args) {
		Scanner leer= new Scanner(System.in);
		cad1=leer.nextLine();
		cad2=leer.nextLine();
		int dist= hammingDistance();
		System.out.println(dist);
		leer.close();

	}
	private static int hammingDistance() {
		int d=0;
		for (int i = 0; i < cad1.length(); i++) {
			if(cad1.charAt(i)!=cad2.charAt(i)){
				d++;
			}
		}
		return d;
	}

}
