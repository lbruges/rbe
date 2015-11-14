import java.util.LinkedHashMap;

public class FrequencyArrays {

	private static LinkedHashMap<String, Integer> kmers;
	
	public static void main(String[] args) {
		kmers= new LinkedHashMap<String, Integer>();
		kmers.put("AA", 0);
		kmers.put("AC", 0);
		kmers.put("AG", 0);
		kmers.put("AT", 0);
		kmers.put("CA", 0);
		kmers.put("CC", 0);
		kmers.put("CG", 0);
		kmers.put("CT", 0);
		kmers.put("GA", 0);
		kmers.put("GC", 0);
		kmers.put("GG", 0);
		kmers.put("GT", 0);
		kmers.put("TA", 0);
		kmers.put("TC", 0);
		kmers.put("TG", 0);
		kmers.put("TT", 0);
		
	}

}
