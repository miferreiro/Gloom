

	import java.util.Scanner;


	public class ES {
		
	public static Scanner leer = new Scanner (System.in);

	public static String pideCadena (String mensaje){
		
		//Poner mensaje
		
		System.out.print(mensaje);
		
		//Pedir
		
		return leer.nextLine();
	}

	public static int leeNum(String msg)
	{
	    boolean repite;
	    int toret = 0;
	

	    do {
	        repite = false;
	        System.out.print( msg );

	        try {
	            toret = Integer.parseInt( leer.nextLine() );
	        } catch (NumberFormatException exc) {
	            repite = true;
	        }
	    } while( repite );

	    return toret;
	}

}

