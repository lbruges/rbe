import java.util.Arrays;

public class TestPlace {

	public static void main(String[] args) {
		int[] arr={0,1,2,3};
		int temp=0;
		for (int i = 1; i < arr.length; i++) {
			temp+=arr[i];
		}
		for (int i = arr.length-1; i > 0; i--) {
			arr[i]=arr[i-1];
		}
		
		
		System.out.println(Arrays.toString(arr));

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
