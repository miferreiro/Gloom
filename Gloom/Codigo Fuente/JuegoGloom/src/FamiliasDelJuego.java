
public class FamiliasDelJuego {
	
	static CartaPersonaje [][] familias = {
			  {new CartaPersonaje("Pulgarcita"), new CartaPersonaje("Señor Risas"), new CartaPersonaje("Elissandre"),new CartaPersonaje("Darius"),new CartaPersonaje("Samson")}, 
			  {new CartaPersonaje("Los gemelos"), new CartaPersonaje("Goody Zarr"), new CartaPersonaje("Butterfield"), new CartaPersonaje("Lola"), new CartaPersonaje("Lord")},
			  {new CartaPersonaje("Angel"), new CartaPersonaje("Balthazar"), new CartaPersonaje("Willen"), new CartaPersonaje("Primo"), new CartaPersonaje("Dam")}, 
			  {new CartaPersonaje("Grogar"), new CartaPersonaje("Melisa"), new CartaPersonaje("Helena"), new CartaPersonaje("Slogar"), new CartaPersonaje("Elias")}
			  };
	static String[] nombre = {"Azul","Roja","Verde","Amarilla"};
	
	public static Familia getFamilia(int i)
	{
		return new Familia(nombre[i],familias[i]);
	}
	
	/**
	 * 
	 * @return las familias del juego
	 */
	
	public static String mostrarFamilia(){
		
		String toret = "";
		
		for(int i = 0;i < 4;i++){
			
			toret += + i + 1 + ": Familia " + nombre[i] + ": ";
			
			for(int j = 0;j < 5;j++){
				
				toret += familias[i][j].getNombre() + "  ";
				
			}		
			toret += "\n";
		}
		
		return toret;
	}
	
	

}
