import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class prueba4 {
	private static String cadena;
	private static HashMap<Character,Double> protein;
	private static BufferedReader bf;
	
	public static void main(String args[]){
		initializeProtein();
		leerCadena("rosalind_prtm.txt");
		System.out.println(totalWeight());
		//weight_table.txt
	}
	
	private static void leerCadena(String filename){
		cadena="";
		try{
			BufferedReader br=new BufferedReader(new FileReader(filename));
			String line;
			while((line=br.readLine())!=null){
				cadena+=line;
			}
			br.close();
		}
		catch(IOException e){
			System.out.println("Something has happened.");
		}
	}
	

	
	private static void initializeProtein(){
		protein=new HashMap<Character,Double>();
		String ln="";
		try{
			bf=new BufferedReader(new FileReader("weight_table.txt"));
			while((ln=bf.readLine())!=null){
				String[] split=ln.split(" ");
				protein.put(split[0].charAt(0), Double.parseDouble(split[1]));
			}
			
		}catch(IOException e){
			System.out.println("Something has happened.");
		}
	}
	
	private static double totalWeight(){
		double weight=0;
		for (int i = 0; i < cadena.length(); i++) {
			weight+=protein.get(cadena.charAt(i));
		}
		return weight;
	}

}
