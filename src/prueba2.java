import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class prueba2 {
	
	public static HashMap<Character, Integer> map;
	public static String cadena;
	
	public static void main(String args[]){
		map= new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 0);
		map.put('G', 0);
		map.put('T', 0);
		leerCadena();
		nucleotidsCount();
		System.out.println(map);
	}
	
	private static void leerCadena(){
		cadena="";
		try{
			BufferedReader br=new BufferedReader(new FileReader("rosalind_dna(1).txt"));
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
	
	private static void nucleotidsCount(){
		for (int i = 0; i < cadena.length(); i++) {
			map.put(cadena.charAt(i), map.get(cadena.charAt(i))+1);
		}
	}

}
