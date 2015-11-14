import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class ComputingGCContent {

	private static HashMap<String,String> map;
	public static void main(String[] args) {
		map=new HashMap<String,String>();
		leerFasta("rosalind_gc(5).txt");
		System.out.println(getPercentages());
		
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

	private static String getPercentages(){
		float porcentaje_max=0;
		String max="";
		Iterator<String> iter=map.keySet().iterator();
		while(iter.hasNext()){
			String key=iter.next(),temp_cont=map.get(key);
			float cont=0;
			for (int i = 0; i < temp_cont.length(); i++) {
				if(temp_cont.charAt(i)=='C'||temp_cont.charAt(i)=='G'){
					cont++;
				}
			}
			float porcentaje=(cont/map.get(key).length())*100;
			if(porcentaje>porcentaje_max){
				porcentaje_max=porcentaje;
				max=key;
			}
			
		}
		return max+"\n"+porcentaje_max;
	}

}

