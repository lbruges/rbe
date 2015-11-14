import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountingPointMutations {
	private static String s,t;
	public static void main(String[] args) {
		leerCadena("rosalind_hamm.txt");
		System.out.println(distance());

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
	
	private static int distance(){
		int dist=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)!=t.charAt(i)){
				dist++;
			}
		}
		return dist;
	}

}
