import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class prueba {
	
	public static void main(String[] args){
		String cadena="",patron,line;
		try{
			BufferedReader bf= new BufferedReader(new FileReader("rosalind_ba1d.txt"));
			patron=bf.readLine();
			while((line=bf.readLine())!=null){
				cadena+=line;
			}
			for (int i = 0; i <= cadena.length()-patron.length(); i++) {
				if(cadena.substring(i, patron.length()+i).equals(patron)){
					System.out.print(i+" ");
				}
			}
			bf.close();
		
		}catch(IOException e){
			System.out.println("Something has happened");
		}
		
	}

}
