import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindingMotifinDNA {
	private static String s,t;
	public static void main(String[] args) {
		leerCadena("rosalind_subs.txt");
		positions();
	}
	
	private static void leerCadena(String filename){

		try{
			BufferedReader br=new BufferedReader(new FileReader(filename));
			s=br.readLine();
			t=br.readLine();
			br.close();
		}
		catch(IOException e){
			System.out.println("Something has happened.");
		}
	}
	
	private static void positions(){
		for (int i = 0; i <= s.length()-t.length(); i++) {
			if(s.substring(i, i+t.length()).equals(t)){
				System.out.print((i+1)+" ");
			}
		}
	}

}
