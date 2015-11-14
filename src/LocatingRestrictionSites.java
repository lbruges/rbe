import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LocatingRestrictionSites {
	private static HashMap<String,String> map;

	public static void main(String[] args) {
		map=new HashMap<String,String>();
		leerFasta("rosalind_revp.txt");
		palyndrome(map.get("Rosalind_9067"));

	}
	
	private static void leerFasta(String filename){
		try{
			BufferedReader br=new BufferedReader(new FileReader(filename));
			String line,last_line="",last_content="";
			
			while((line=br.readLine())!=null){
				if(line.charAt(0)=='>'){
					last_line=line.substring(line.indexOf('>')+1);
					last_content="";
					map.put(last_line, last_content);
				}else{
					last_content+=line;
					map.put(last_line, last_content);
				}
				
			}
			br.close();
		}
		catch(IOException e){
			System.out.println("Something has happened.");
		}
	}
	
	private static void palyndrome(String s){
		
		for (int i = 0; i < s.length(); i++) {
			for (int k = s.length(); k >= 0 && k>i; k--) {
				if((k-i)%2==0&&(k-i)>=4&&(k-i)<=12){
					String temp=s.substring(i,k);
					if(temp.equals(reverse(temp))){
						System.out.println((i+1)+" "+(k-i));
					}
				}
			}
			

		}

	}
	
	private static String reverse(String cadena){
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
	
	

}
