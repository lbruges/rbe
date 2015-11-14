import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class HiddenPath2 {

	
	private static LinkedList<String> rows,columns;
	private static double[][] matrix;
	private static String[] path1,path2;
	
	private static double prob;
	
	public static void main(String[] args) {
		rows= new LinkedList<String>();
		columns= new LinkedList<String>();
		prob=1;
		leerArchivo("simple_test2.txt");
		calcularProbabilidad();
		System.out.println(prob);
	}
	
	private static void calcularProbabilidad() {
		for (int i = 0; i < path2.length; i++) {
			prob*=matrix[rows.indexOf(path2[i])][columns.indexOf(path1[i])];
			
		}
		
	}


	private static void leerArchivo(String filename){
		try{
			BufferedReader br= new BufferedReader(new FileReader(filename));
			path1=br.readLine().split("");
			br.readLine();
			String[] temp=br.readLine().split(" ");
			for (int i = 0; i < temp.length; i++) {
				columns.add(temp[i]);
			}
			br.readLine();
			path2=br.readLine().split("");
			br.readLine();
			temp= br.readLine().split(" ");
			for (int i = 0; i < temp.length; i++) {
				rows.add(temp[i]);
			}
			matrix= new double[rows.size()][columns.size()];
			br.readLine();
			br.readLine();
			String line;
			int i=0;
			while((line=br.readLine())!=null){
				String[] subs=line.substring(line.indexOf(" ")+1).split(" ");
				for (int j = 0; j < subs.length; j++) {
					matrix[i][j]=Double.parseDouble(subs[j]);
				}
				i++;
			}
			
			for (int j = 0; j < rows.size(); j++) {
				for (int j2 = 0; j2 < columns.size(); j2++) {
					System.out.print(matrix[j][j2]+" ");
				}
				System.out.println();
			}
			
			br.close();
			
		}catch (IOException ioe){
			System.out.println("Something went wrong");
		}
		
	}
	

}
