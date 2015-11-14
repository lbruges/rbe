import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;


public class SomeClass {

	public static void main(String[] args) {
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("short_test.txt"));
			String line;
			String s = "";
			while((line = br.readLine())!=null){
				s+=line;
			}
			System.out.println("Archivo leido!");
			Scanner input = new Scanner(System.in);
			TreeSet<String> mayores = new TreeSet<String>();
			int ultimo = Integer.MIN_VALUE;
			int k = input.nextInt();
			int d = input.nextInt();
			
			
			for(int i=0; i<=s.length()-k; i++){
				String base = s.substring(i, i+k);
				String baseInv = invertir(base);
				int n = 0;
				String sbusq;
				for(int j=0;j<s.length()-k;j++){
					sbusq = s.substring(j, j+k);
					n += distance0(base,sbusq , d);
					n+= distance(baseInv, sbusq, d);
					
				}
				
				if(ultimo < n){
					ultimo = n;
					mayores.clear();
					mayores.add(base);
				}else if(ultimo == n){
					mayores.add(base);
				}
				
			}
			
			
			for(String w : mayores){
				System.out.print(w+" ");
			}
			
			br.close();
			
			input.close();
		}catch(FileNotFoundException e){
			System.out.println("Archivo NO!");
			
		}catch(IOException e){
			System.out.println("Archivo NO leido!");
		}
		
		
		

	}
	
	private static char invertir(char c){
		switch(c){
			case 'C':
				return 'G';
			case 'A':
				return 'T';
			case 'G':
				return 'C';
			case 'T':
				return 'A';
			default:
				return 'H';
			
		}
		
	}
	private static String invertir(String s){
		String m = "";
		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)){
			case 'C':
				m += 'G';
				break;
			case 'A':
				m += 'T';
				break;
			case 'G':
				m += 'C';
				break;
			case 'T':
				m += 'A';
				break;
			default:
				m += 'H';
				break;
			}
		}
		return m;
				
	}
	
	//ultimo < n
	private static int distance0(String base, String busqueda, int d){
		int dist = 0;
		for (int i = 0; (i < base.length()) && (dist<=d); i++) {
			if(base.charAt(i)!=busqueda.charAt(i)){
				dist++;
			}	
		}
		if(dist<=d){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	private static int distance(String base, String busqueda, int d){
		int dist1=0;
		int dist2=0;
		for (int i = 0; i < base.length(); i++) {
			if(base.charAt(i)!=busqueda.charAt(i)){
				dist1++;
			}
			if(invertir(base.charAt(i))!=busqueda.charAt(i)){
				dist2++;
			}
		}
		
		if(dist1 <= d && dist2 <= d){
			return 2;
		}else if((dist1>d && dist2<=d) || (dist1<=d && dist2 >d)){
			return 1;
		}else{
			return 0;
		}

	}
}
