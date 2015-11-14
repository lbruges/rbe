import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class prueba3 {
	
	private static String cadena;
	
	public static void main(String[] args) {
		leerCadena("rosalind_ba1c.txt");
		System.out.println(complement());
		escribirCadena(complement(),"result.txt");
		
	}
	
	private static String complement(){
		String comp="";
		for (int i = 0; i < cadena.length(); i++) {
			switch(cadena.charAt(i)){
			case 'A':
				comp='T'+comp;
				break;
			case 'T':
				comp='A'+comp;
				break;
			case 'C':
				comp='G'+comp;
				break;
			case 'G':
				comp='C'+comp;
				break;
			}
		}
		return comp;
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
	
	private static void escribirCadena(String cad,String filename){
		try{
			BufferedWriter bw= new BufferedWriter(new FileWriter(filename));
			bw.write(cad);
			bw.close();
		}catch(IOException e){
			
		}
	}

}
