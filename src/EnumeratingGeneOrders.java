import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class EnumeratingGeneOrders {
	private static int num;
	private static int[] arr;
	public static LinkedHashSet<String> set;

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		num=input.nextInt();
		arr=new int[num];
		set= new LinkedHashSet<String>();
		generateArray();
		permutations(0);
		System.out.println(set.size());
		Iterator<String> iter= set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			
		}
		input.close();

	}

	private static void permutations(int k) {
		for (int i = k; i < arr.length; i++) {
			swap(i, k);
			permutations(k+1);
			swap(i, k);
		}
		if(k==arr.length-1){
			set.add(asString());
		}
	}

	private static void generateArray() {
		int cont=1;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=cont;
			cont++;
		}
		
	}
	
	private static void swap(int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	private static String asString(){
		String res="";
		for (int i = 0; i < arr.length; i++) {
			res+=arr[i]+" ";
		}
		return res;
	}

}
