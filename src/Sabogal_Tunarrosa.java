
//Presentado por: Sabogal_Naydu y Tunarrosa_Yohana

public class Sabogal_Tunarrosa {
	public static int matriz[][] = new int[4][4];
	public static int d = 0;
	public static int a = 0;
	public static String cadi[][] = { { " ", "A", "A", "G" },{ " ", "A", "G", "T" } };
	public static String matriz2[][] = { { "x", "x", "x", "x" },{ "x", "x", "x", "x" } };

	public static void main(String[] args) {
		
		for (int i = 0; i < matriz.length; i++) {

			matriz[0][i] = d;
			matriz[i][0] = d;
			d = d - 5;
		}

		llenar();
		System.out.println("MATRIZ LLENA:");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				
				System.out.print("    "+matriz[i][j]);
			}
			System.out.println();
		}
		
		int izq=0, diag=0,arri=0, posi=0,posj=0, x=0,k=0;

		
		for (int i = matriz.length-1; i >=0; i--) {
			
			for (int j = matriz.length-1; j >=0; j--) {
				k++;
				if(x==0){
				posi=i;
				posj=j;
				arri=matriz[matriz.length-2][matriz.length-1];
				izq=matriz[matriz.length-1][matriz.length-2];
				diag=matriz[matriz.length-2][matriz.length-2];
				System.out.println("Valores alredor");

				System.out.println("arri: "+arri+" izq: "+izq+" diag: "+diag);
				x=1;
				}else{
					arri=matriz[posi-1][posj];
					izq=matriz[posi][posj-1];
					diag=matriz[posi-1][posj-1];
					System.out.println("Valores alredor");
					
					System.out.println(" arri: "+arri+" izq: "+izq+" diag: "+diag);
				}
								
				if (izq >= arri && izq>= diag) {
					matriz2[0][i]="__";
					matriz2[1][i]=cadi[1][i];
					posi=posi;
//					 System.out.println("i "+i+"posi "+posi);
					 posj=posj-1;
//					  System.out.println(posi);
					 System.out.println("Se escoge izquierda"+matriz[posi][posj]);
					
				}
				
				if (arri >= izq && arri >= diag) {
					 
						matriz2[0][i]=cadi[1][i];
						matriz2[1][i]="__";
					posi=posi-1;
//					 System.out.println("i "+i+"posi "+posi);

					 posj=posj;

//					 System.out.println(posi);
					 System.out.println("Se escoge arriba"+matriz[posi][posj]);
					

				}
				if (diag >= izq && diag >= arri) {
					posi=posi-1;
//					 System.out.println("i "+i+"posi "+posi);

					 posj=posj-1;

//					 System.out.println(posi);
					 System.out.println("Se escoge diagonal"+diag);
//						 System.out.println("cad"+cadi[0][i]);
					 matriz2[0][i]=cadi[0][i+1];
						matriz2[1][i]=cadi[1][posj+1];
						
				}	break;
				
			}	
			
			System.out.println();
			

		}
		
		System.out.println("RESULTADO:");

		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2[i].length; j++) {
				System.out.print("  "+matriz2[i][j]);
			}
			System.out.println();
		}
		
		
	}
		

	private static int calcular(String i, String j) {
		String caso;
		int a = 0;

		

		caso = i + j;
//		System.out.println(caso);
		if (caso.equals("AT") || caso.equals("TA") || caso.equals("GC")
				|| caso.equals("CG")) {
			a = -1;
		
		} else if (caso.equals("AA") || caso.equals("TT") || caso.equals("GG")
				|| caso.equals("CC")) {
			a = 2;
		} else {
			a = -7;
		}

//			System.out.println("a" + a);

		return a;
	}

	private static void llenar() {
		int valor1, valor2, valor3;
		String posI, posJ;

		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz.length; j++) {

				posI = cadi[0][i];
				posJ = cadi[1][j];
				valor1 = calcular(posI, posJ) + matriz[i - 1][j - 1];

				valor2 = -5 + matriz[i - 1][j];
				valor3 = -5 + matriz[i][j - 1];

//				System.out.println("v1" + valor1 + "v2" + valor2 + "v3"	+ valor3);

				if (valor1 >= valor2 && valor1 >= valor3) {
					matriz[i][j] = valor1;
				}
				if (valor2 >= valor1 && valor2 >= valor3) {
					matriz[i][j] = valor2;
				}
				if (valor3 >= valor1 && valor3 >= valor2) {
					matriz[i][j] = valor3;
				}
			}

		}

	}

}