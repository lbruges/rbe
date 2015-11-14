import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class HiddenPath {

	
	private static LinkedList<String> nodes;
	private static double[][] matrix;
	private static String[] path;
	private static double prob;
	
	public static void main(String[] args) {
		nodes= new LinkedList<String>();
		prob=1;
		leerArchivo("simple_test1.txt");
		calcularProbabilidad();
		System.out.println(prob);
	}
	
	private static void calcularProbabilidad() {
		for (int i = 0; i < path.length-1; i++) {
			System.out.println(path[i]+" --> "+path[i+1]);
			System.out.println(matrix[nodes.indexOf(path[i])][nodes.indexOf(path[i+1])]);
			prob*=matrix[nodes.indexOf(path[i])][nodes.indexOf(path[i+1])];
			//System.out.println(prob);
		}
		prob=prob/nodes.size();
		
	}


	private static void leerArchivo(String filename){
		try{
			BufferedReader br= new BufferedReader(new FileReader(filename));
			path=br.readLine().split("");
			br.readLine();
			String[] temp= br.readLine().split(" ");
			for (int i = 0; i < temp.length; i++) {
				nodes.add(temp[i]);
			}
			matrix= new double[temp.length][temp.length];
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
			
			
			br.close();
			
		}catch (IOException ioe){
			System.out.println("Something went wrong");
		}
		
	}
	

}
